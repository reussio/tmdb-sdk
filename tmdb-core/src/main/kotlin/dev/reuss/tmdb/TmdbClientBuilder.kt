package dev.reuss.tmdb

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Region
import java.time.Duration

/**
 * Builder for creating [TmdbClient] instances.
 *
 * The builder configures authentication, the TMDB API base URL and default
 * request settings such as language, region and timeouts.
 *
 * At minimum, an access token or [TmdbAuth] instance must be provided
 * before calling [build].
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
     * Sets the TMDB bearer access token.
     */
    fun accessToken(accessToken: String): TmdbClientBuilder = apply {
        auth = TmdbAuth.bearerToken(accessToken)
    }

    /**
     * Sets the TMDB authentication configuration.
     */
    fun auth(auth: TmdbAuth): TmdbClientBuilder = apply {
        this.auth = auth
    }

    /**
     * Sets the TMDB API base URL.
     *
     * The default value is `https://api.themoviedb.org/3`.
     * This is mainly useful for testing or custom deployments.
     */
    fun baseUrl(baseUrl: String): TmdbClientBuilder = apply {
        this.baseUrl = baseUrl
    }

    /**
     * Sets the default language for localized TMDB requests.
     *
     * The default value is [Languages.EN_US].
     */
    fun defaultLanguage(defaultLanguage: Language): TmdbClientBuilder = apply {
        this.defaultLanguage = defaultLanguage
    }

    /**
     * Sets the default region for regional TMDB requests.
     *
     * The default region is optional and may be `null`.
     */
    fun defaultRegion(defaultRegion: Region?): TmdbClientBuilder = apply {
        this.defaultRegion = defaultRegion
    }

    /**
     * Sets the HTTP connection timeout.
     *
     * The default value is 5 seconds.
     */
    fun connectTimeout(connectTimeout: Duration): TmdbClientBuilder = apply {
        this.connectTimeout = connectTimeout
    }

    /**
     * Sets the overall HTTP request timeout.
     *
     * The default value is 10 seconds.
     */
    fun requestTimeout(requestTimeout: Duration): TmdbClientBuilder = apply {
        this.requestTimeout = requestTimeout
    }

    /**
     * Sets the metrics recorder used to observe TMDB HTTP requests.
     *
     * The default recorder is a no-op implementation.
     */
    fun metricsRecorder(metricsRecorder: TmdbMetricsRecorder): TmdbClientBuilder = apply {
        this.metricsRecorder = metricsRecorder
    }

    /**
     * Builds a new [TmdbClient].
     */
    fun build(): TmdbClient {
        val auth = requireNotNull(auth) {
            "TMDB auth must not be null"
        }

        val config = TmdbClientConfig(
            auth,
            baseUrl,
            defaultLanguage,
            defaultRegion,
            connectTimeout,
            requestTimeout,
            metricsRecorder
        )

        return DefaultTmdbClient(config)
    }
}