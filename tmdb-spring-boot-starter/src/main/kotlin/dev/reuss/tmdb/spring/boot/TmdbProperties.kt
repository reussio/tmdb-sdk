package dev.reuss.tmdb.spring.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

/**
 * Configuration properties for the TMDB client.
 *
 * @property accessToken TMDB API access token
 * @property baseUrl TMDB API base URL
 * @property defaultLanguage default language
 * @property defaultRegion default region
 * @property connectTimeout HTTP connection timeout
 * @property requestTimeout HTTP request timeout
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
