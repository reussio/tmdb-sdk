package dev.reuss.tmdb.domain.reviews;

import dev.reuss.tmdb.value.id.ReviewId;

final class ReviewPaths {

    private static final String REVIEW = "/review";

    private ReviewPaths() {
    }

    static String details(ReviewId reviewId) {
        return REVIEW + "/" + reviewId.asString();
    }
}