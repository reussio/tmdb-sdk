package dev.reuss.tmdb.domain.watchproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * TMDB watch provider list.
 *
 * @param results watch providers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WatchProviders(
        List<WatchProvider> results
) implements TmdbModel {

    public WatchProviders {
        results = TmdbCollections.list(results);
    }

}
