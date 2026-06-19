package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Content ratings for a TMDB TV series.
 *
 * @param id      TMDB TV series id
 * @param results content ratings
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesContentRatings(
        int id,
        List<TvSeriesContentRating> results
) implements TmdbModel {

    public TvSeriesContentRatings {
        results = TmdbCollections.list(results);
    }
}