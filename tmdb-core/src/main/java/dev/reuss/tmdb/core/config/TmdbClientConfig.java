package dev.reuss.tmdb.core.config;

import dev.reuss.tmdb.core.auth.TmdbAuth;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.io.Serializable;
import java.time.Duration;
import java.util.Objects;

/**
 * Configuration used to create and operate a TMDB client instance.
 *
 * <p>This record contains authentication, endpoint and default request
 * settings shared by all services created by the client.</p>
 *
 * <p>The {@code defaultLanguage} is used by services when no request-specific
 * language is provided. The {@code defaultRegion} is optional and may be
 * {@code null}, because not every TMDB endpoint or request requires a region.</p>
 *
 * @param auth            the TMDB authentication configuration
 * @param baseUrl         the TMDB API base URL, usually {@code https://api.themoviedb.org/3}
 * @param defaultLanguage the default language used for localized requests
 * @param defaultRegion   the optional default region used for regional requests
 * @param connectTimeout  the HTTP connection timeout
 * @param requestTimeout  the overall HTTP request timeout
 */
public record TmdbClientConfig(
        TmdbAuth auth,
        String baseUrl,
        Language defaultLanguage,
        Region defaultRegion,
        Duration connectTimeout,
        Duration requestTimeout
) implements Serializable {
    /**
     * Creates a new TMDB client configuration.
     *
     * @throws NullPointerException     if {@code auth}, {@code defaultLanguage},
     *                                  {@code connectTimeout} or {@code requestTimeout} is {@code null}
     * @throws IllegalArgumentException if {@code baseUrl} is {@code null}, blank or empty,
     *                                  or if a timeout is zero or negative
     */
    public TmdbClientConfig {
        Objects.requireNonNull(auth, "TMDB auth must not be null");

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalArgumentException("TMDB base URL must not be blank");
        }

        baseUrl = baseUrl.trim();

        Objects.requireNonNull(defaultLanguage, "Default language must not be null");
        Objects.requireNonNull(connectTimeout, "Connect timeout must not be null");
        Objects.requireNonNull(requestTimeout, "Request timeout must not be null");

        if (connectTimeout.isZero() || connectTimeout.isNegative()) {
            throw new IllegalArgumentException("Connect timeout must be greater than zero");
        }

        if (requestTimeout.isZero() || requestTimeout.isNegative()) {
            throw new IllegalArgumentException("Request timeout must be greater than zero");
        }
    }
}
