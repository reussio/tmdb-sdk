package dev.reuss.tmdb.domain.search.model.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB movie search response.
 *
 * @param page         current result page
 * @param results      found movies
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchMovieResponse(
        int page,

        List<SearchMovie> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<SearchMovie>, TmdbModel {

    public SearchMovieResponse {
        results = TmdbCollections.list(results);
        ;
    }
}