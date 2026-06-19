package dev.reuss.tmdb.domain.watchproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Available TMDB watch provider regions.
 *
 * @param results available regions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WatchProviderRegions(
        List<WatchProviderRegion> results
) implements TmdbModel {

    public WatchProviderRegions {
        results = TmdbCollections.list(results);
    }
}