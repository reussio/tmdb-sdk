package dev.reuss.tmdb.spring.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

/**
 * External configuration for the auto-configured TMDB client.
 *
 * @property accessToken Required TMDB API read access token used as a bearer token.
 * @property baseUrl API base URL; blank or absent values use `https://api.themoviedb.org/3/`.
 * @property defaultLanguage Default TMDB language tag; blank or absent values use `en-US`.
 * @property defaultRegion Optional ISO 3166-1 region added to requests by default.
 * @property connectTimeout Positive HTTP connection timeout; absent values use 10 seconds.
 * @property requestTimeout Positive per-request timeout; absent values use 30 seconds.
 */
@ConfigurationProperties(prefix = "tmdb")
data class TmdbProperties(
    val accessToken: String?,
    val baseUrl: String?,
    val defaultLanguage: String?,
    val defaultRegion: String?,
    val connectTimeout: Duration?,
    val requestTimeout: Duration?,
)
