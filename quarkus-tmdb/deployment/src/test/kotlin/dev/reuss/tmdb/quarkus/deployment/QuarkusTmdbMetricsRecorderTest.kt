package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.quarkus.runtime.QuarkusTmdbMetricsRecorder
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.IOException
import java.time.Duration
import java.util.concurrent.TimeUnit
import java.util.stream.Stream

class QuarkusTmdbMetricsRecorderTest {
    @Test
    fun shouldRecordRequestDurationWithBoundedTags() {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = QuarkusTmdbMetricsRecorder(meterRegistry)

        recorder.recordRequestStarted(
            "GET",
            "/movie/550/recommendations",
        )
        recorder.recordRequestFinished(
            "GET",
            "/movie/550/recommendations",
            200,
            Duration.ofMillis(42),
            128,
        )

        assertEquals(
            1L,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}/recommendations")
                .tag("status", "200")
                .tag("status_family", "2xx")
                .tag("outcome", "SUCCESS")
                .timer()
                .count(),
        )

        assertEquals(
            42.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .timer()
                .totalTime(TimeUnit.MILLISECONDS),
        )

        assertEquals(
            1.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.REQUEST_TOTAL_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}/recommendations")
                .tag("status", "200")
                .tag("status_family", "2xx")
                .tag("outcome", "SUCCESS")
                .counter()
                .count(),
        )

        assertEquals(
            128.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.RESPONSE_BYTES_METRIC)
                .summary()
                .totalAmount(),
        )

        assertEquals(
            0.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value(),
        )
    }

    @Test
    fun shouldRecordExceptionsAsCounterAndRequestTimer() {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = QuarkusTmdbMetricsRecorder(meterRegistry)

        recorder.recordRequestStarted(
            "GET",
            "/person/287",
        )

        assertEquals(
            1.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value(),
        )

        recorder.recordRequestFailed(
            "GET",
            "/person/287",
            IOException("connection failed"),
            Duration.ofMillis(5),
        )

        assertEquals(
            1.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("method", "GET")
                .tag("path", "/person/{id}")
                .tag("type", "exception")
                .tag("exception", "IOException")
                .counter()
                .count(),
        )

        assertEquals(
            1L,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/person/{id}")
                .tag("status", "IO_ERROR")
                .tag("status_family", "IO_ERROR")
                .tag("outcome", "ERROR")
                .timer()
                .count(),
        )

        assertEquals(
            0.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value(),
        )
    }

    @Test
    fun shouldRecordApiErrorsAndRateLimitHits() {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = QuarkusTmdbMetricsRecorder(meterRegistry)

        recorder.recordRequestStarted(
            "GET",
            "/search/movie",
        )
        recorder.recordRequestFinished(
            "GET",
            "/search/movie",
            429,
            Duration.ofMillis(12),
            64,
        )

        assertEquals(
            1.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("method", "GET")
                .tag("path", "/search/movie")
                .tag("type", "api")
                .tag("status", "429")
                .tag("status_family", "4xx")
                .counter()
                .count(),
        )

        assertEquals(
            1.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.RATE_LIMIT_HITS_METRIC)
                .tag("method", "GET")
                .tag("path", "/search/movie")
                .counter()
                .count(),
        )
    }

    @ParameterizedTest(name = "HTTP {0} -> {1}/{2}")
    @MethodSource("statusOutcomes")
    fun recordRequestFinished_shouldClassifyStatusFamilyAndOutcome(
        statusCode: Int,
        statusFamily: String,
        outcome: String,
    ) {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = QuarkusTmdbMetricsRecorder(meterRegistry)

        recorder.recordRequestStarted("GET", "/tv/1399")
        recorder.recordRequestFinished(
            "GET",
            "/tv/1399",
            statusCode,
            Duration.ofMillis(12),
            64,
        )

        assertEquals(
            1L,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("path", "/tv/{id}")
                .tag("status", statusCode.toString())
                .tag("status_family", statusFamily)
                .tag("outcome", outcome)
                .timer()
                .count(),
        )
        if (statusCode >= 400) {
            assertEquals(
                1.0,
                meterRegistry
                    .get(QuarkusTmdbMetricsRecorder.ERRORS_METRIC)
                    .tag("type", "api")
                    .tag("status", statusCode.toString())
                    .counter()
                    .count(),
            )
        }
    }

    @Test
    fun shouldRecordMappingErrors() {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = QuarkusTmdbMetricsRecorder(meterRegistry)

        recorder.recordMappingFailed(
            "GET",
            "/movie/550",
            SuccessResponse::class.java,
            IllegalArgumentException("bad json"),
        )

        assertEquals(
            1.0,
            meterRegistry
                .get(QuarkusTmdbMetricsRecorder.MAPPING_ERRORS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .tag("response_type", "SuccessResponse")
                .tag("exception", "IllegalArgumentException")
                .counter()
                .count(),
        )
    }

    @Test
    fun normalizePath_shouldReplaceEveryNumericResourceSegment() {
        assertEquals(
            "/tv/{id}/season/{id}/episode/{id}",
            QuarkusTmdbMetricsRecorder.normalizePath("/tv/1399/season/1/episode/2"),
        )
        assertEquals(
            "/tv/episode_group/group-1",
            QuarkusTmdbMetricsRecorder.normalizePath("/tv/episode_group/group-1"),
        )
    }

    private data class SuccessResponse(
        val id: Int,
    )

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
