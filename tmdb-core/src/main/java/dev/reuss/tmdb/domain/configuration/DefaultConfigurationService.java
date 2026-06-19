package dev.reuss.tmdb.domain.configuration;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration;

import java.util.Objects;

/**
 * Default {@link ConfigurationService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultConfigurationService implements ConfigurationService {

    private final TmdbHttpClient httpClient;

    /**
     * Creates a new configuration service.
     *
     * @param httpClient the TMDB HTTP client
     * @throws NullPointerException if {@code httpClient} is {@code null}
     */
    public DefaultConfigurationService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    /**
     * Loads the TMDB API configuration from {@code /configuration}.
     *
     * @return the TMDB API configuration
     */
    @Override
    public ApiConfiguration apiConfiguration() {
        return httpClient.get(TmdbRequest.get(ConfigurationPaths.details()), ApiConfiguration.class);
    }
}