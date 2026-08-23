package dev.reuss.tmdb.domain.reviews

import dev.reuss.tmdb.domain.reviews.model.Review
import dev.reuss.tmdb.value.id.ReviewId

/** Loads a TMDB user review independently of its associated media item. */
interface ReviewService {
    /** Returns the review identified by [reviewId]. */
    fun details(reviewId: ReviewId): Review
}
