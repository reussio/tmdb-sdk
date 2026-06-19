package dev.reuss.tmdb.domain.discover.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB TV discover response.
 *
 * @param page         current result page
 * @param results      discovered TV shows
 * @param totalPages   total available pages
 * @param totalResults total available results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DiscoverTvShowResponse(
        int page,

        List<DiscoverTvShow> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<DiscoverTvShow>, TmdbModel {

    public DiscoverTvShowResponse {
        results = TmdbCollections.list(results);
        ;
    }
}
