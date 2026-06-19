package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.watchprovider.WatchProviderAvailability;
import dev.reuss.tmdb.common.watchprovider.WatchProvidersResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.Map;

/**
 * Watch provider availabilities for a TMDB TV series.
 *
 * @param id      TMDB TV series id
 * @param results watch providers grouped by region code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesWatchProviders(
        int id,
        Map<String, WatchProviderAvailability> results
) implements WatchProvidersResponse<WatchProviderAvailability>, TmdbModel {

    public TvSeriesWatchProviders {
        results = TmdbCollections.map(results);
    }
}
