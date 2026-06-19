package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Recommended TV series for a TMDB TV series.
 *
 * @param page         current page
 * @param results      recommended TV series
 * @param totalPages   total pages
 * @param totalResults total results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesRecommendations(
        int page,

        List<TvSeriesRecommendation> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<TvSeriesRecommendation>, TmdbModel {

    public TvSeriesRecommendations {
        results = TmdbCollections.list(results);
    }
}