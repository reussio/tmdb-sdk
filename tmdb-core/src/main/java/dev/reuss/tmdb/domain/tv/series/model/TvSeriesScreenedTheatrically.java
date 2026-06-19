package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * TV series episodes that have screened theatrically.
 *
 * @param id      TMDB TV series id
 * @param results theatrically screened episodes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesScreenedTheatrically(
        int id,
        List<TvSeriesScreenedTheatricallyEpisode> results
) implements TmdbModel {

    public TvSeriesScreenedTheatrically {
        results = TmdbCollections.list(results);
    }
}