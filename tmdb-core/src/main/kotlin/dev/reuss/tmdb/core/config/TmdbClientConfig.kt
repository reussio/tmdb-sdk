package dev.reuss.tmdb.core.config

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.net.URI
import java.net.URISyntaxException
import java.time.Duration

/**
 * Validated configuration consumed by the default TMDB HTTP client.
 *
 * [baseUrl] is trimmed and must be an absolute HTTP(S) URL with a host and no
 * query or fragment. Both timeout values must be positive. [defaultLanguage]
 * and [defaultRegion] are merged into every request unless that request supplies
 * the same query parameter explicitly.
 *
 * @property auth Bearer authentication applied to every request.
 * @property baseUrl Base URL for TMDB-compatible API requests.
 * @property defaultLanguage Fallback `language` query parameter.
 * @property defaultRegion Optional fallback `region` query parameter.
 * @property connectTimeout Maximum time allowed to establish a connection.
 * @property requestTimeout Timeout applied to each HTTP request.
 * @property metricsRecorder Observer for HTTP request lifecycle events.
 * @throws IllegalArgumentException if the base URL or either timeout is invalid
 */
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

        val baseUri =
            try {
                URI(this.baseUrl)
            } catch (exception: URISyntaxException) {
                throw IllegalArgumentException(
                    "TMDB base URL must be an absolute HTTP(S) URL",
                    exception,
                )
            }

        require(
            baseUri.host != null &&
                (
                    baseUri.scheme.equals("http", ignoreCase = true) ||
                        baseUri.scheme.equals("https", ignoreCase = true)
                ) &&
                baseUri.query == null &&
                baseUri.fragment == null,
        ) {
            "TMDB base URL must be an absolute HTTP(S) URL without query or fragment"
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
