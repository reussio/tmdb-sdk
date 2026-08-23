package dev.reuss.tmdb.domain.reviews

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.ReviewId

internal object ReviewPaths {
    fun details(reviewId: ReviewId): String = tmdbPath("review", reviewId)
}
