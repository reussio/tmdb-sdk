package dev.reuss.tmdb.core.metrics

import java.time.Duration

/**
 * Observes the lifecycle of requests made by the default TMDB HTTP client.
 *
 * All callbacks have no-op defaults so consumers can implement only the events
 * they need. A started request receives exactly one finished or failed callback;
 * response mapping failure is reported separately after a successful HTTP response.
 */
interface TmdbMetricsRecorder {
    /** Called immediately before the HTTP request is sent. */
    fun recordRequestStarted(
        method: String,
        path: String,
    ) = Unit

    /**
     * Called after an HTTP response is received, including non-successful statuses.
     *
     * @param duration Elapsed request time.
     * @param responseBytes UTF-8 byte length of the response body.
     */
    fun recordRequestFinished(
        method: String,
        path: String,
        statusCode: Int,
        duration: Duration,
        responseBytes: Long,
    ) = Unit

    /** Called when transport or interruption prevents an HTTP response. */
    fun recordRequestFailed(
        method: String,
        path: String,
        exception: Throwable,
        duration: Duration,
    ) = Unit

    /** Called when a successful response cannot be mapped to [responseType]. */
    fun recordMappingFailed(
        method: String,
        path: String,
        responseType: Class<*>,
        exception: Throwable,
    ) = Unit

    companion object {
        /** Recorder that discards all events. */
        @JvmField
        val NOOP: TmdbMetricsRecorder = object : TmdbMetricsRecorder {}
    }
}
