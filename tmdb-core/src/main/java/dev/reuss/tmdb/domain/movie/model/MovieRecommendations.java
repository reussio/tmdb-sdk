package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paged recommendations for a TMDB movie.
 *
 * @param page         current page
 * @param results      recommended movies
 * @param totalPages   total pages
 * @param totalResults total results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieRecommendations(
        int page,

        List<RecommendedMovie> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<RecommendedMovie>, TmdbModel {

    public MovieRecommendations {
        results = TmdbCollections.list(results);
    }
}