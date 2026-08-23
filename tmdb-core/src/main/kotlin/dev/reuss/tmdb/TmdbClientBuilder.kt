package dev.reuss.tmdb

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Region
import java.time.Duration

/**
 * Configures the default [TmdbClient] implementation.
 *
 * The builder configures authentication, the TMDB API base URL and default
 * request settings such as language, region and timeouts.
 *
 * A bearer access token or [TmdbAuth] is required. Unless overridden, requests
 * use TMDB API v3, `en-US`, a five-second connection timeout, a ten-second
 * request timeout, no default region, and no-op metrics.
 *
 * Example:
 *
 * ```
 * val tmdb = TmdbClient.builder()
 *     .accessToken("your-access-token")
 *     .defaultLanguage(Languages.DE_DE)
 *     .build()
 * ```
 *
 * @see TmdbClient
 * @see TmdbAuth
 * @see TmdbClientConfig
 */
class TmdbClientBuilder {
    private var auth: TmdbAuth? = null
    private var baseUrl: String = TmdbClientConfig.DEFAULT_BASE_URL
    private var defaultLanguage: Language = Languages.EN_US
    private var defaultRegion: Region? = null
    private var connectTimeout: Duration = TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT_DURATION
    private var requestTimeout: Duration = TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT_DURATION
    private var metricsRecorder: TmdbMetricsRecorder = TmdbMetricsRecorder.NOOP

    /**
     * Uses [accessToken] for bearer authentication.
     *
     * The token is trimmed and must not be blank.
     *
     * @throws IllegalArgumentException if [accessToken] is blank
     */
    fun accessToken(accessToken: String): TmdbClientBuilder =
        apply {
            auth = TmdbAuth.bearerToken(accessToken)
        }

    /** Uses an already validated authentication value. */
    fun auth(auth: TmdbAuth): TmdbClientBuilder =
        apply {
            this.auth = auth
        }

    /**
     * Overrides the TMDB API base URL.
     *
     * The default value is `https://api.themoviedb.org/3`.
     * The value is validated by [build] as an absolute HTTP(S) URL without a
     * query or fragment. This setting is mainly useful for tests and compatible
     * proxy deployments.
     */
    fun baseUrl(baseUrl: String): TmdbClientBuilder =
        apply {
            this.baseUrl = baseUrl
        }

    /**
     * Sets the language added to requests that do not override `language`.
     *
     * The default value is [Languages.EN_US].
     */
    fun defaultLanguage(defaultLanguage: Language): TmdbClientBuilder =
        apply {
            this.defaultLanguage = defaultLanguage
        }

    /**
     * Sets the region added to requests that do not override `region`.
     *
     * The default is `null`, which omits the parameter.
     */
    fun defaultRegion(defaultRegion: Region?): TmdbClientBuilder =
        apply {
            this.defaultRegion = defaultRegion
        }

    /**
     * Sets the maximum time allowed to establish an HTTP connection.
     *
     * The default is five seconds. [build] rejects zero and negative durations.
     */
    fun connectTimeout(connectTimeout: Duration): TmdbClientBuilder =
        apply {
            this.connectTimeout = connectTimeout
        }

    /**
     * Sets the timeout applied to each HTTP request.
     *
     * The default is ten seconds. [build] rejects zero and negative durations.
     */
    fun requestTimeout(requestTimeout: Duration): TmdbClientBuilder =
        apply {
            this.requestTimeout = requestTimeout
        }

    /**
     * Sets the observer notified about TMDB HTTP request lifecycle events.
     *
     * The default is [TmdbMetricsRecorder.NOOP].
     */
    fun metricsRecorder(metricsRecorder: TmdbMetricsRecorder): TmdbClientBuilder =
        apply {
            this.metricsRecorder = metricsRecorder
        }

    /**
     * Validates the accumulated configuration and creates a client.
     *
     * @throws IllegalArgumentException if authentication is missing or the base URL
     * or either timeout is invalid
     */
    fun build(): TmdbClient {
        val auth =
            requireNotNull(auth) {
                "TMDB auth must not be null"
            }

        val config =
            TmdbClientConfig(
                auth,
                baseUrl,
                defaultLanguage,
                defaultRegion,
                connectTimeout,
                requestTimeout,
                metricsRecorder,
            )

        return DefaultTmdbClient(config)
    }
}
