package dev.reuss.tmdb.domain.search.model.multi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB multi search response.
 *
 * @param page         current result page
 * @param results      found movies, TV shows and people
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchMultiResponse(
        int page,

        List<SearchMultiResult> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<SearchMultiResult>, TmdbModel {

    public SearchMultiResponse {
        results = TmdbCollections.list(results);
        ;
    }
}