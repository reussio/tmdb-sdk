package dev.reuss.tmdb.domain.tv.series

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvShowImages
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesAggregateCredits
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesAlternativeTitles
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesChanges
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesContentRatings
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesCredits
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesEpisodeGroups
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesKeywords
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesRecommendations
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesReviews
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesScreenedTheatrically
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesSimilar
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesTranslations
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesVideos
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesWatchProviders
import dev.reuss.tmdb.query.AppendableResponse

/**
 * Supported TV series `append_to_response` values.
 */
enum class TvSeriesAppend(
    override val value: String,
    override val responseType: Class<*>,
) : AppendableResponse {
    AGGREGATE_CREDITS("aggregate_credits", TvSeriesAggregateCredits::class.java),
    ALTERNATIVE_TITLES("alternative_titles", TvSeriesAlternativeTitles::class.java),
    CHANGES("changes", TvSeriesChanges::class.java),
    CONTENT_RATINGS("content_ratings", TvSeriesContentRatings::class.java),
    CREDITS("credits", TvSeriesCredits::class.java),
    EPISODE_GROUPS("episode_groups", TvSeriesEpisodeGroups::class.java),
    EXTERNAL_IDS("external_ids", ExternalIds::class.java),
    IMAGES("images", TvShowImages::class.java),
    KEYWORDS("keywords", TvSeriesKeywords::class.java),
    RECOMMENDATIONS("recommendations", TvSeriesRecommendations::class.java),
    REVIEWS("reviews", TvSeriesReviews::class.java),
    SCREENED_THEATRICALLY("screened_theatrically", TvSeriesScreenedTheatrically::class.java),
    SIMILAR("similar", TvSeriesSimilar::class.java),
    TRANSLATIONS("translations", TvSeriesTranslations::class.java),
    VIDEOS("videos", TvSeriesVideos::class.java),
    WATCH_PROVIDERS("watch/providers", TvSeriesWatchProviders::class.java),
}
