package dev.reuss.tmdb.domain.configuration;

import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration;

/**
 * Service for loading TMDB API configuration metadata.
 *
 * <p>The configuration contains image base URLs and supported image sizes
 * required to build complete TMDB image URLs.</p>
 *
 * @see <a href="https://developer.themoviedb.org/reference/configuration-details">TMDB Configuration</a>
 */
public interface ConfigurationService {

    /**
     * Loads the TMDB API configuration.
     *
     * @return the TMDB API configuration
     */
    ApiConfiguration apiConfiguration();
}