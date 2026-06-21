package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Micrometer-backed metrics recorder for the TMDB SDK.
 */
public class SpringTmdbMetricsRecorder implements TmdbMetricsRecorder {

    public static final String REQUESTS_METRIC = "tmdb.client.requests";
    public static final String REQUEST_TOTAL_METRIC = "tmdb.client.request";
    public static final String ERRORS_METRIC = "tmdb.client.errors";
    public static final String RATE_LIMIT_HITS_METRIC = "tmdb.client.rate.limit.hits";
    public static final String ACTIVE_REQUESTS_METRIC = "tmdb.client.requests.active";
    public static final String RESPONSE_BYTES_METRIC = "tmdb.client.response.bytes";
    public static final String MAPPING_ERRORS_METRIC = "tmdb.client.mapping.errors";

    private final MeterRegistry meterRegistry;
    private final AtomicInteger activeRequests;

    public SpringTmdbMetricsRecorder(MeterRegistry meterRegistry) {
        this.meterRegistry = Objects.requireNonNull(meterRegistry, "meterRegistry must not be null");
        this.activeRequests = meterRegistry.gauge(
                ACTIVE_REQUESTS_METRIC,
                new AtomicInteger()
        );
    }

    @Override
    public void recordRequestStarted(String method, String path) {
        activeRequests.incrementAndGet();
    }

    @Override
    public void recordRequestFinished(String method, String path, int statusCode, Duration duration, long responseBytes) {
        activeRequests.decrementAndGet();

        String normalizedPath = normalizePath(path);
        String status = Integer.toString(statusCode);
        String statusFamily = statusFamily(statusCode);
        String outcome = outcome(statusCode);

        Timer.builder(REQUESTS_METRIC)
                .description("TMDB client request duration")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("status", status)
                .tag("status_family", statusFamily)
                .tag("outcome", outcome)
                .publishPercentileHistogram()
                .publishPercentiles(0.95, 0.99)
                .register(meterRegistry)
                .record(duration);

        Counter.builder(REQUEST_TOTAL_METRIC)
                .description("TMDB client request count")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("status", status)
                .tag("status_family", statusFamily)
                .tag("outcome", outcome)
                .register(meterRegistry)
                .increment();

        DistributionSummary.builder(RESPONSE_BYTES_METRIC)
                .description("TMDB client response payload size")
                .baseUnit("bytes")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("status", status)
                .tag("status_family", statusFamily)
                .tag("outcome", outcome)
                .register(meterRegistry)
                .record(responseBytes);

        if (statusCode >= 400) {
            Counter.builder(ERRORS_METRIC)
                    .description("TMDB client errors")
                    .tag("method", method)
                    .tag("path", normalizedPath)
                    .tag("type", "api")
                    .tag("status", status)
                    .tag("status_family", statusFamily)
                    .register(meterRegistry)
                    .increment();
        }

        if (statusCode == 429) {
            Counter.builder(RATE_LIMIT_HITS_METRIC)
                    .description("TMDB client rate limit hits")
                    .tag("method", method)
                    .tag("path", normalizedPath)
                    .register(meterRegistry)
                    .increment();
        }
    }

    @Override
    public void recordRequestFailed(String method, String path, Throwable exception, Duration duration) {
        activeRequests.decrementAndGet();

        String normalizedPath = normalizePath(path);
        String exceptionName = exception.getClass().getSimpleName();

        Counter.builder(ERRORS_METRIC)
                .description("TMDB client errors")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("type", "exception")
                .tag("exception", exceptionName)
                .register(meterRegistry)
                .increment();

        Timer.builder(REQUESTS_METRIC)
                .description("TMDB client request duration")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("status", "IO_ERROR")
                .tag("status_family", "IO_ERROR")
                .tag("outcome", "ERROR")
                .publishPercentileHistogram()
                .publishPercentiles(0.95, 0.99)
                .register(meterRegistry)
                .record(duration);

        Counter.builder(REQUEST_TOTAL_METRIC)
                .description("TMDB client request count")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("status", "IO_ERROR")
                .tag("status_family", "IO_ERROR")
                .tag("outcome", "ERROR")
                .register(meterRegistry)
                .increment();
    }

    @Override
    public void recordMappingFailed(String method, String path, Class<?> responseType, Throwable exception) {
        Counter.builder(MAPPING_ERRORS_METRIC)
                .description("TMDB client JSON mapping errors")
                .tag("method", method)
                .tag("path", normalizePath(path))
                .tag("response_type", responseType.getSimpleName())
                .tag("exception", exception.getClass().getSimpleName())
                .register(meterRegistry)
                .increment();
    }

    static String normalizePath(String path) {
        return path.replaceAll("/\\d+(?=/|$)", "/{id}");
    }

    private static String statusFamily(int statusCode) {
        return (statusCode / 100) + "xx";
    }

    private static String outcome(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) {
            return "SUCCESS";
        }
        if (statusCode >= 400 && statusCode < 500) {
            return "CLIENT_ERROR";
        }
        if (statusCode >= 500) {
            return "SERVER_ERROR";
        }
        return "UNKNOWN";
    }
}
