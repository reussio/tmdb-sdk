package dev.reuss.tmdb.quarkus.runtime;

import dev.reuss.tmdb.core.config.TmdbClientConfig;
import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;
import java.time.Duration;
import java.util.Optional;

/**
 * Runtime configuration for the TMDB Quarkus extension.
 */
@StaticInitSafe
@ConfigMapping(prefix = "tmdb")
public interface TmdbConfig {

    /**
     * TMDB API read access token.
     *
     * @return configured access token
     */
    @WithName("access-token")
    Optional<String> accessToken();

    /**
     * TMDB API base URL.
     *
     * @return configured TMDB base URL
     */
    @WithName("base-url")
    @WithDefault(TmdbClientConfig.DEFAULT_BASE_URL)
    String baseUrl();

    /**
     * Default language used for TMDB requests.
     *
     * @return configured default language
     */
    @WithName("default-language")
    @WithDefault(TmdbClientConfig.DEFAULT_LANGUAGE)
    String defaultLanguage();

    /**
     * Default region used for TMDB requests.
     *
     * @return configured default region
     */
    @WithName("default-region")
    Optional<String> defaultRegion();

    /**
     * Connect timeout used by the TMDB HTTP client.
     *
     * @return configured connect timeout
     */
    @WithName("connect-timeout")
    @WithDefault(TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT)
    Duration connectTimeout();

    /**
     * Request timeout used by the TMDB HTTP client.
     *
     * @return configured request timeout
     */
    @WithName("request-timeout")
    @WithDefault(TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT)
    Duration requestTimeout();
}
