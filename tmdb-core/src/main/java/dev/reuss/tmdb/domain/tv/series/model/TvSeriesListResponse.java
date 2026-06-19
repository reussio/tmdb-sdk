package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB TV series list response.
 *
 * @param page         current page
 * @param results      TV series results
 * @param totalPages   total pages
 * @param totalResults total results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesListResponse(
        int page,
        List<TvSeriesListItem> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<TvSeriesListItem>, TmdbModel {

    public TvSeriesListResponse {
        results = TmdbCollections.list(results);
    }
}
