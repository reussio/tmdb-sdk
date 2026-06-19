package dev.reuss.tmdb.domain.trending.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB trending movie response.
 *
 * @param page         current result page
 * @param results      trending movies
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TrendingMovieResponse(
        int page,

        List<TrendingMovie> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<TrendingMovie>, TmdbModel {

    public TrendingMovieResponse {
        results = TmdbCollections.list(results);
        ;
    }
}
