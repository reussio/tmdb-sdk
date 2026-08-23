package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.core.config.TmdbClientConfig
import io.quarkus.runtime.annotations.StaticInitSafe
import io.smallrye.config.ConfigMapping
import io.smallrye.config.WithDefault
import io.smallrye.config.WithName
import java.time.Duration
import java.util.Optional

/**
 * Runtime configuration under the `tmdb` prefix.
 *
 * Although [accessToken] is represented as optional for configuration mapping, client creation
 * fails at runtime initialization when it is absent or blank.
 */
@StaticInitSafe
@ConfigMapping(prefix = "tmdb")
interface TmdbConfig {
    /** Required TMDB API read access token used as a bearer token. */
    @WithName("access-token")
    fun accessToken(): Optional<String>

    /** API base URL; defaults to `https://api.themoviedb.org/3/`. */
    @WithName("base-url")
    @WithDefault(TmdbClientConfig.DEFAULT_BASE_URL)
    fun baseUrl(): String

    /** Default TMDB language tag added to requests; defaults to `en-US`. */
    @WithName("default-language")
    @WithDefault(TmdbClientConfig.DEFAULT_LANGUAGE)
    fun defaultLanguage(): String

    /** Optional ISO 3166-1 region added to requests by default. */
    @WithName("default-region")
    fun defaultRegion(): Optional<String>

    /** Positive HTTP connection timeout; defaults to 10 seconds. */
    @WithName("connect-timeout")
    @WithDefault(TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT)
    fun connectTimeout(): Duration

    /** Positive per-request timeout; defaults to 30 seconds. */
    @WithName("request-timeout")
    @WithDefault(TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT)
    fun requestTimeout(): Duration
}
