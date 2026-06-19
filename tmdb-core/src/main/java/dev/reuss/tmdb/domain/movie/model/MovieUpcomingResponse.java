package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paginated TMDB upcoming movie response.
 *
 * @param dates        result date range
 * @param page         current page
 * @param results      movie results
 * @param totalPages   total pages
 * @param totalResults total results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieUpcomingResponse(
        MovieNowPlayingDates dates,

        int page,

        List<MovieListItem> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<MovieListItem>, TmdbModel {

    public MovieUpcomingResponse {
        results = TmdbCollections.list(results);
    }
}
