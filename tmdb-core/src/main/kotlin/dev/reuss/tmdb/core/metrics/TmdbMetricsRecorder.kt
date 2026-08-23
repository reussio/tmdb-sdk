package dev.reuss.tmdb.core.metrics

import java.time.Duration

interface TmdbMetricsRecorder {
    fun recordRequestStarted(
        method: String,
        path: String,
    ) = Unit

    fun recordRequestFinished(
        method: String,
        path: String,
        statusCode: Int,
        duration: Duration,
        responseBytes: Long,
    ) = Unit

    fun recordRequestFailed(
        method: String,
        path: String,
        exception: Throwable,
        duration: Duration,
    ) = Unit

    fun recordMappingFailed(
        method: String,
        path: String,
        responseType: Class<*>,
        exception: Throwable,
    ) = Unit

    companion object {
        @JvmField
        val NOOP: TmdbMetricsRecorder = object : TmdbMetricsRecorder {}
    }
}
