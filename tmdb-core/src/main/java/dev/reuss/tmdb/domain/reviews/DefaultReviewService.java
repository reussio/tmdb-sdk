package dev.reuss.tmdb.domain.reviews;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.reviews.model.Review;
import dev.reuss.tmdb.value.id.ReviewId;

import java.util.Objects;

/**
 * Default {@link ReviewService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultReviewService implements ReviewService {

    private final TmdbHttpClient httpClient;

    public DefaultReviewService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public Review details(ReviewId reviewId) {
        Objects.requireNonNull(reviewId, "Review id must not be null");

        return httpClient.get(
                TmdbRequest.get(ReviewPaths.details(reviewId)),
                Review.class
        );
    }
}