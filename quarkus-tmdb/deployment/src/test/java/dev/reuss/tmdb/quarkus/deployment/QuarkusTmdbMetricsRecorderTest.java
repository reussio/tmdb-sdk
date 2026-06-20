package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.quarkus.runtime.QuarkusTmdbMetricsRecorder;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuarkusTmdbMetricsRecorderTest {

    @Test
    void shouldRecordRequestDurationWithBoundedTags() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        QuarkusTmdbMetricsRecorder recorder = new QuarkusTmdbMetricsRecorder(meterRegistry);

        recorder.recordRequestStarted("GET", "/movie/550/recommendations");
        recorder.recordRequestFinished("GET", "/movie/550/recommendations", 200, Duration.ofMillis(42), 128);

        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}/recommendations")
                .tag("status", "200")
                .tag("status_family", "2xx")
                .tag("outcome", "SUCCESS")
                .timer()
                .count());
        assertEquals(42, meterRegistry.get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .timer()
                .totalTime(TimeUnit.MILLISECONDS));
        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.REQUEST_TOTAL_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}/recommendations")
                .tag("status", "200")
                .tag("status_family", "2xx")
                .tag("outcome", "SUCCESS")
                .counter()
                .count());
        assertEquals(128, meterRegistry.get(QuarkusTmdbMetricsRecorder.RESPONSE_BYTES_METRIC)
                .summary()
                .totalAmount());
        assertEquals(0, meterRegistry.get(QuarkusTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value());
    }

    @Test
    void shouldRecordExceptionsAsCounterAndRequestTimer() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        QuarkusTmdbMetricsRecorder recorder = new QuarkusTmdbMetricsRecorder(meterRegistry);

        recorder.recordRequestStarted("GET", "/person/287");
        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value());

        recorder.recordRequestFailed("GET", "/person/287", new IOException("connection failed"), Duration.ofMillis(5));

        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("method", "GET")
                .tag("path", "/person/{id}")
                .tag("type", "exception")
                .tag("exception", "IOException")
                .counter()
                .count());
        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/person/{id}")
                .tag("status", "IO_ERROR")
                .tag("status_family", "IO_ERROR")
                .tag("outcome", "ERROR")
                .timer()
                .count());
        assertEquals(0, meterRegistry.get(QuarkusTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value());
    }

    @Test
    void shouldRecordApiErrorsAndRateLimitHits() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        QuarkusTmdbMetricsRecorder recorder = new QuarkusTmdbMetricsRecorder(meterRegistry);

        recorder.recordRequestStarted("GET", "/search/movie");
        recorder.recordRequestFinished("GET", "/search/movie", 429, Duration.ofMillis(12), 64);

        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("method", "GET")
                .tag("path", "/search/movie")
                .tag("type", "api")
                .tag("status", "429")
                .tag("status_family", "4xx")
                .counter()
                .count());
        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.RATE_LIMIT_HITS_METRIC)
                .tag("method", "GET")
                .tag("path", "/search/movie")
                .counter()
                .count());
    }

    @Test
    void shouldRecordMappingErrors() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        QuarkusTmdbMetricsRecorder recorder = new QuarkusTmdbMetricsRecorder(meterRegistry);

        recorder.recordMappingFailed(
                "GET",
                "/movie/550",
                SuccessResponse.class,
                new IllegalArgumentException("bad json")
        );

        assertEquals(1, meterRegistry.get(QuarkusTmdbMetricsRecorder.MAPPING_ERRORS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .tag("response_type", "SuccessResponse")
                .tag("exception", "IllegalArgumentException")
                .counter()
                .count());
    }

    private record SuccessResponse(int id) {
    }
}
