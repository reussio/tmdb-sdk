package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.page.PagedResponse;
import dev.reuss.tmdb.common.review.Review;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Paged reviews for a TMDB movie.
 *
 * @param id           TMDB movie id
 * @param page         current page
 * @param results      movie reviews
 * @param totalPages   total pages
 * @param totalResults total results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieReviews(
        int id,

        int page,

        List<Review> results,

        @JsonProperty("total_pages")
        int totalPages,

        @JsonProperty("total_results")
        int totalResults
) implements PagedResponse<Review>, TmdbModel {

    public MovieReviews {
        results = TmdbCollections.list(results);
    }
}
