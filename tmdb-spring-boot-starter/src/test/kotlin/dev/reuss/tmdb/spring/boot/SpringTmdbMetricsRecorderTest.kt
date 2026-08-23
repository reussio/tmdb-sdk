package dev.reuss.tmdb.spring.boot

import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.IOException
import java.time.Duration
import java.util.stream.Stream

class SpringTmdbMetricsRecorderTest {
    @Test
    fun recordRequestFinished_shouldRecordSuccessMetricsAndResponseBytes() {
        val registry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(registry)

        recorder.recordRequestStarted("GET", "/movie/550/recommendations")
        assertEquals(1.0, registry.get(SpringTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC).gauge().value())

        recorder.recordRequestFinished(
            "GET",
            "/movie/550/recommendations",
            200,
            Duration.ofMillis(25),
            512,
        )

        assertEquals(0.0, registry.get(SpringTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC).gauge().value())
        assertEquals(
            1L,
            registry
                .get(SpringTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}/recommendations")
                .tag("status", "200")
                .tag("status_family", "2xx")
                .tag("outcome", "SUCCESS")
                .timer()
                .count(),
        )
        assertEquals(
            1.0,
            registry
                .get(SpringTmdbMetricsRecorder.REQUEST_TOTAL_METRIC)
                .tag("status", "200")
                .counter()
                .count(),
        )
        assertEquals(
            512.0,
            registry
                .get(SpringTmdbMetricsRecorder.RESPONSE_BYTES_METRIC)
                .tag("status", "200")
                .summary()
                .totalAmount(),
        )
    }

    @ParameterizedTest(name = "HTTP {0} -> {1}/{2}")
    @MethodSource("statusOutcomes")
    fun recordRequestFinished_shouldClassifyStatusFamilyAndOutcome(
        statusCode: Int,
        statusFamily: String,
        outcome: String,
    ) {
        val registry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(registry)

        recorder.recordRequestStarted("GET", "/search/movie")
        recorder.recordRequestFinished(
            "GET",
            "/search/movie",
            statusCode,
            Duration.ofMillis(1),
            0,
        )

        assertEquals(
            1L,
            registry
                .get(SpringTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("status_family", statusFamily)
                .tag("outcome", outcome)
                .timer()
                .count(),
        )
        if (statusCode >= 400) {
            assertEquals(
                1.0,
                registry
                    .get(SpringTmdbMetricsRecorder.ERRORS_METRIC)
                    .tag("type", "api")
                    .tag("status", statusCode.toString())
                    .tag("status_family", statusFamily)
                    .counter()
                    .count(),
            )
        }
    }

    @Test
    fun recordRequestFinished_shouldRecordRateLimitHit_whenStatusIs429() {
        val registry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(registry)

        recorder.recordRequestStarted("GET", "/movie/550")
        recorder.recordRequestFinished("GET", "/movie/550", 429, Duration.ofMillis(2), 128)

        assertEquals(
            1.0,
            registry
                .get(SpringTmdbMetricsRecorder.RATE_LIMIT_HITS_METRIC)
                .tag("path", "/movie/{id}")
                .counter()
                .count(),
        )
    }

    @Test
    fun recordRequestFailed_shouldRecordExceptionAndIoOutcome() {
        val registry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(registry)

        recorder.recordRequestStarted("GET", "/person/287")
        recorder.recordRequestFailed(
            "GET",
            "/person/287",
            IOException("connection failed"),
            Duration.ofMillis(5),
        )

        assertEquals(0.0, registry.get(SpringTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC).gauge().value())
        assertEquals(
            1.0,
            registry
                .get(SpringTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("path", "/person/{id}")
                .tag("type", "exception")
                .tag("exception", "IOException")
                .counter()
                .count(),
        )
        assertEquals(
            1L,
            registry
                .get(SpringTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("status", "IO_ERROR")
                .tag("status_family", "IO_ERROR")
                .tag("outcome", "ERROR")
                .timer()
                .count(),
        )
    }

    @Test
    fun recordMappingFailed_shouldRecordResponseTypeExceptionAndNormalizedPath() {
        val registry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(registry)

        recorder.recordMappingFailed(
            "GET",
            "/tv/1399/season/1/episode/2",
            String::class.java,
            IllegalArgumentException("invalid"),
        )

        assertEquals(
            1.0,
            registry
                .get(SpringTmdbMetricsRecorder.MAPPING_ERRORS_METRIC)
                .tag("path", "/tv/{id}/season/{id}/episode/{id}")
                .tag("response_type", "String")
                .tag("exception", "IllegalArgumentException")
                .counter()
                .count(),
        )
    }

    @Test
    fun normalizePath_shouldReplaceNumericIdsButPreserveOpaqueIdsAndQueryText() {
        assertEquals("/movie/{id}", SpringTmdbMetricsRecorder.normalizePath("/movie/550"))
        assertEquals(
            "/tv/{id}/season/{id}/episode/{id}",
            SpringTmdbMetricsRecorder.normalizePath("/tv/1399/season/1/episode/2"),
        )
        assertEquals(
            "/tv/episode_group/group-1",
            SpringTmdbMetricsRecorder.normalizePath("/tv/episode_group/group-1"),
        )
    }

    companion object {
        @JvmStatic
        fun statusOutcomes(): Stream<Arguments> =
            Stream.of(
                Arguments.of(204, "2xx", "SUCCESS"),
                Arguments.of(302, "3xx", "UNKNOWN"),
                Arguments.of(404, "4xx", "CLIENT_ERROR"),
                Arguments.of(503, "5xx", "SERVER_ERROR"),
            )
    }
}
