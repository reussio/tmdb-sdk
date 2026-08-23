package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.DistributionSummary
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import java.time.Duration
import java.util.concurrent.atomic.AtomicInteger

/**
 * Micrometer-backed metrics recorder for the TMDB SDK.
 */
class SpringTmdbMetricsRecorder(
    private val meterRegistry: MeterRegistry,
) : TmdbMetricsRecorder {
    private val activeRequests: AtomicInteger =
        meterRegistry.gauge(
            ACTIVE_REQUESTS_METRIC,
            AtomicInteger(),
        )

    override fun recordRequestStarted(
        method: String,
        path: String,
    ) {
        activeRequests.incrementAndGet()
    }

    override fun recordRequestFinished(
        method: String,
        path: String,
        statusCode: Int,
        duration: Duration,
        responseBytes: Long,
    ) {
        activeRequests.decrementAndGet()

        val normalizedPath = normalizePath(path)
        val status = statusCode.toString()
        val statusFamily = statusFamily(statusCode)
        val outcome = outcome(statusCode)

        Timer
            .builder(REQUESTS_METRIC)
            .description("TMDB client request duration")
            .tag("method", method)
            .tag("path", normalizedPath)
            .tag("status", status)
            .tag("status_family", statusFamily)
            .tag("outcome", outcome)
            .publishPercentileHistogram()
            .publishPercentiles(0.95, 0.99)
            .register(meterRegistry)
            .record(duration)

        Counter
            .builder(REQUEST_TOTAL_METRIC)
            .description("TMDB client request count")
            .tag("method", method)
            .tag("path", normalizedPath)
            .tag("status", status)
            .tag("status_family", statusFamily)
            .tag("outcome", outcome)
            .register(meterRegistry)
            .increment()

        DistributionSummary
            .builder(RESPONSE_BYTES_METRIC)
            .description("TMDB client response payload size")
            .baseUnit("bytes")
            .tag("method", method)
            .tag("path", normalizedPath)
            .tag("status", status)
            .tag("status_family", statusFamily)
            .tag("outcome", outcome)
            .register(meterRegistry)
            .record(responseBytes.toDouble())

        if (statusCode >= 400) {
            Counter
                .builder(ERRORS_METRIC)
                .description("TMDB client errors")
                .tag("method", method)
                .tag("path", normalizedPath)
                .tag("type", "api")
                .tag("status", status)
                .tag("status_family", statusFamily)
                .register(meterRegistry)
                .increment()
        }

        if (statusCode == 429) {
            Counter
                .builder(RATE_LIMIT_HITS_METRIC)
                .description("TMDB client rate limit hits")
                .tag("method", method)
                .tag("path", normalizedPath)
                .register(meterRegistry)
                .increment()
        }
    }

    override fun recordRequestFailed(
        method: String,
        path: String,
        exception: Throwable,
        duration: Duration,
    ) {
        activeRequests.decrementAndGet()

        val normalizedPath = normalizePath(path)
        val exceptionName = exception.javaClass.simpleName

        Counter
            .builder(ERRORS_METRIC)
            .description("TMDB client errors")
            .tag("method", method)
            .tag("path", normalizedPath)
            .tag("type", "exception")
            .tag("exception", exceptionName)
            .register(meterRegistry)
            .increment()

        Timer
            .builder(REQUESTS_METRIC)
            .description("TMDB client request duration")
            .tag("method", method)
            .tag("path", normalizedPath)
            .tag("status", "IO_ERROR")
            .tag("status_family", "IO_ERROR")
            .tag("outcome", "ERROR")
            .publishPercentileHistogram()
            .publishPercentiles(0.95, 0.99)
            .register(meterRegistry)
            .record(duration)

        Counter
            .builder(REQUEST_TOTAL_METRIC)
            .description("TMDB client request count")
            .tag("method", method)
            .tag("path", normalizedPath)
            .tag("status", "IO_ERROR")
            .tag("status_family", "IO_ERROR")
            .tag("outcome", "ERROR")
            .register(meterRegistry)
            .increment()
    }

    override fun recordMappingFailed(
        method: String,
        path: String,
        responseType: Class<*>,
        exception: Throwable,
    ) {
        Counter
            .builder(MAPPING_ERRORS_METRIC)
            .description("TMDB client JSON mapping errors")
            .tag("method", method)
            .tag("path", normalizePath(path))
            .tag("response_type", responseType.simpleName)
            .tag("exception", exception.javaClass.simpleName)
            .register(meterRegistry)
            .increment()
    }

    companion object {
        const val REQUESTS_METRIC = "tmdb.client.requests"
        const val REQUEST_TOTAL_METRIC = "tmdb.client.request"
        const val ERRORS_METRIC = "tmdb.client.errors"
        const val RATE_LIMIT_HITS_METRIC = "tmdb.client.rate.limit.hits"
        const val ACTIVE_REQUESTS_METRIC = "tmdb.client.requests.active"
        const val RESPONSE_BYTES_METRIC = "tmdb.client.response.bytes"
        const val MAPPING_ERRORS_METRIC = "tmdb.client.mapping.errors"

        private val ID_PATH_SEGMENT = Regex("/\\d+(?=/|$)")

        @JvmStatic
        fun normalizePath(path: String): String = path.replace(ID_PATH_SEGMENT, "/{id}")

        private fun statusFamily(statusCode: Int): String = "${statusCode / 100}xx"

        private fun outcome(statusCode: Int): String =
            when {
                statusCode in 200..299 -> "SUCCESS"
                statusCode in 400..499 -> "CLIENT_ERROR"
                statusCode >= 500 -> "SERVER_ERROR"
                else -> "UNKNOWN"
            }
    }
}
