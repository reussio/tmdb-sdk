package dev.reuss.tmdb.domain.reviews

import dev.reuss.tmdb.domain.reviews.model.Review
import dev.reuss.tmdb.value.id.ReviewId

/**
 * Service for loading TMDB review metadata.
 */
interface ReviewService {
    /**
     * Loads review details by review id.
     *
     * @param reviewId the review id
     * @return review details
     */
    fun details(reviewId: ReviewId): Review
}
