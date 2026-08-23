package dev.reuss.tmdb.core.config

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.time.Duration

class TmdbClientConfig(
    val auth: TmdbAuth,
    baseUrl: String,
    val defaultLanguage: Language,
    val defaultRegion: Region?,
    val connectTimeout: Duration,
    val requestTimeout: Duration,
    val metricsRecorder: TmdbMetricsRecorder,
) {
    val baseUrl: String = baseUrl.trim()

    init {
        require(this.baseUrl.isNotBlank()) {
            "TMDB base URL must not be blank"
        }

        require(!connectTimeout.isZero && !connectTimeout.isNegative) {
            "Connect timeout must be greater than zero"
        }

        require(!requestTimeout.isZero && !requestTimeout.isNegative) {
            "Request timeout must be greater than zero"
        }
    }

    companion object {
        const val DEFAULT_BASE_URL = "https://api.themoviedb.org/3"
        const val DEFAULT_LANGUAGE = "en-US"
        const val DEFAULT_CONNECT_TIMEOUT = "5s"
        const val DEFAULT_REQUEST_TIMEOUT = "10s"

        @JvmField
        val DEFAULT_CONNECT_TIMEOUT_DURATION: Duration = Duration.ofSeconds(5)

        @JvmField
        val DEFAULT_REQUEST_TIMEOUT_DURATION: Duration = Duration.ofSeconds(10)
    }
}
