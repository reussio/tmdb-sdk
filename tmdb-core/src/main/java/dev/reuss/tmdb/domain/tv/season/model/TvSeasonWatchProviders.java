package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.watchprovider.WatchProviderAvailability;
import dev.reuss.tmdb.common.watchprovider.WatchProvidersResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.Map;

/**
 * Watch provider availabilities for a TMDB TV season.
 *
 * @param id      TMDB season id
 * @param results watch providers grouped by region code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonWatchProviders(
        int id,
        Map<String, WatchProviderAvailability> results
) implements WatchProvidersResponse<WatchProviderAvailability>, TmdbModel {

    public TvSeasonWatchProviders {
        results = TmdbCollections.map(results);
    }
}
