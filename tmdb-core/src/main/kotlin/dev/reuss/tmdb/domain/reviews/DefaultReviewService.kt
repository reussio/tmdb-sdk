package dev.reuss.tmdb.domain.reviews

import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.reviews.model.Review
import dev.reuss.tmdb.value.id.ReviewId

/**
 * Default [ReviewService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultReviewService(
    private val httpClient: TmdbHttpClient
) : ReviewService {

    override fun details(reviewId: ReviewId): Review =
        httpClient.get(
            TmdbRequest.get(ReviewPaths.details(reviewId)),
            Review::class.java
        )
}