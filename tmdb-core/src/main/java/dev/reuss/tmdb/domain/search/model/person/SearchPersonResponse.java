package dev.reuss.tmdb.domain.search.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB person search response.
 *
 * @param page         current result page
 * @param results      found people
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchPersonResponse(
        int page,

        List<SearchPerson> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<SearchPerson>, TmdbModel {

    public SearchPersonResponse {
        results = TmdbCollections.list(results);
        ;
    }
}
