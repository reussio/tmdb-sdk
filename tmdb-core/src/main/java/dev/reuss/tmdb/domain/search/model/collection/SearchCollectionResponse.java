package dev.reuss.tmdb.domain.search.model.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB collection search response.
 *
 * @param page         current result page
 * @param results      found collections
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchCollectionResponse(
        int page,

        List<SearchCollection> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<SearchCollection>, TmdbModel {

    public SearchCollectionResponse {
        results = TmdbCollections.list(results);
        ;
    }
}