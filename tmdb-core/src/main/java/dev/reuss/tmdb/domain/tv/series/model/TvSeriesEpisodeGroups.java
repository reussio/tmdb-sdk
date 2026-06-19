package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Episode groups for a TMDB TV series.
 *
 * @param id      TMDB TV series id
 * @param results episode groups
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesEpisodeGroups(
        int id,
        List<TvSeriesEpisodeGroup> results
) implements TmdbModel {

    public TvSeriesEpisodeGroups {
        results = TmdbCollections.list(results);
    }
}