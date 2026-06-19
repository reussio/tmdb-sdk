package dev.reuss.tmdb.domain.search.model.keyword;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.keyword.Keyword;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB keyword search response.
 *
 * @param page         current result page
 * @param results      found keywords
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchKeywordResponse(
        int page,

        List<Keyword> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<Keyword>, TmdbModel {

    public SearchKeywordResponse {
        results = TmdbCollections.list(results);
    }
}
