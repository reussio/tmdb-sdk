package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.quarkus.runtime.QuarkusTmdbMetricsRecorder
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.IOException
import java.time.Duration
import java.util.concurrent.TimeUnit

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

    private data class SuccessResponse(
        val id: Int,
    )
}
