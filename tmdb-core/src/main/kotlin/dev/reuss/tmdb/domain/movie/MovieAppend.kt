package dev.reuss.tmdb.domain.movie

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.MovieImages
import dev.reuss.tmdb.domain.movie.model.*
import dev.reuss.tmdb.query.AppendableResponse

/**
 * Movie responses that can be requested through TMDB's `append_to_response` parameter.
 */
enum class MovieAppend(
    override val value: String,
    override val responseType: Class<*>
) : AppendableResponse {

    ALTERNATIVE_TITLES("alternative_titles", MovieAlternativeTitles::class.java),
    CHANGES("changes", MovieChanges::class.java),
    CREDITS("credits", MovieCredits::class.java),
    EXTERNAL_IDS("external_ids", ExternalIds::class.java),
    IMAGES("images", MovieImages::class.java),
    KEYWORDS("keywords", MovieKeywords::class.java),
    RECOMMENDATIONS("recommendations", MovieRecommendations::class.java),
    RELEASE_DATES("release_dates", MovieReleaseDates::class.java),
    REVIEWS("reviews", MovieReviews::class.java),
    SIMILAR("similar", SimilarMovies::class.java),
    TRANSLATIONS("translations", MovieTranslations::class.java),
    VIDEOS("videos", MovieVideos::class.java),
    WATCH_PROVIDERS("watch/providers", MovieWatchProviders::class.java)
}