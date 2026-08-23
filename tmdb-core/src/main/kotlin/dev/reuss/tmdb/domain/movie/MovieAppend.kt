package dev.reuss.tmdb.domain.movie

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.MovieImages
import dev.reuss.tmdb.domain.movie.model.MovieAlternativeTitles
import dev.reuss.tmdb.domain.movie.model.MovieChanges
import dev.reuss.tmdb.domain.movie.model.MovieCredits
import dev.reuss.tmdb.domain.movie.model.MovieKeywords
import dev.reuss.tmdb.domain.movie.model.MovieRecommendations
import dev.reuss.tmdb.domain.movie.model.MovieReleaseDates
import dev.reuss.tmdb.domain.movie.model.MovieReviews
import dev.reuss.tmdb.domain.movie.model.MovieTranslations
import dev.reuss.tmdb.domain.movie.model.MovieVideos
import dev.reuss.tmdb.domain.movie.model.MovieWatchProviders
import dev.reuss.tmdb.domain.movie.model.SimilarMovies
import dev.reuss.tmdb.query.AppendableResponse

/**
 * Movie responses that can be requested through TMDB's `append_to_response` parameter.
 */
enum class MovieAppend(
    override val value: String,
    override val responseType: Class<*>,
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
    WATCH_PROVIDERS("watch/providers", MovieWatchProviders::class.java),
}
