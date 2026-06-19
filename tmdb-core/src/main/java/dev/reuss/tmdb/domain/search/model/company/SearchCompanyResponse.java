package dev.reuss.tmdb.domain.search.model.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB company search response.
 *
 * @param page         current result page
 * @param results      found companies
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchCompanyResponse(
        int page,

        List<SearchCompany> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<SearchCompany>, TmdbModel {

    public SearchCompanyResponse {
        results = TmdbCollections.list(results);
        ;
    }
}
