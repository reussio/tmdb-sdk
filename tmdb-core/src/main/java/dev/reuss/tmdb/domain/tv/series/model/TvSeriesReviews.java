package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.common.review.Review;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Reviews for a TMDB TV series.
 *
 * @param id           TMDB TV series id
 * @param page         current page
 * @param results      TV series reviews
 * @param totalPages   total pages
 * @param totalResults total results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesReviews(
        int id,

        int page,

        List<Review> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<Review>, TmdbModel {

    public TvSeriesReviews {
        results = TmdbCollections.list(results);
    }
}
