package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.watchprovider.WatchProviderAvailability;
import dev.reuss.tmdb.common.watchprovider.WatchProvidersResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.Map;

/**
 * Watch provider availabilities for a TMDB movie.
 *
 * @param id      TMDB movie id
 * @param results watch providers grouped by region code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieWatchProviders(
        int id,
        Map<String, WatchProviderAvailability> results
) implements WatchProvidersResponse<WatchProviderAvailability>, TmdbModel {

    public MovieWatchProviders {
        results = TmdbCollections.map(results);
    }
}
