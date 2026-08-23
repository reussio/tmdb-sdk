package dev.reuss.tmdb.domain.reviews

import dev.reuss.tmdb.domain.reviews.model.Review
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.ReviewId
import org.junit.jupiter.api.Test

class DefaultReviewServiceTest {
    @Test
    fun details_shouldUseReviewPathAndResponseType() {
        assertRequest<Review>("/review/review-1") {
            DefaultReviewService(it).details(ReviewId.of("review-1"))
        }
    }
}
