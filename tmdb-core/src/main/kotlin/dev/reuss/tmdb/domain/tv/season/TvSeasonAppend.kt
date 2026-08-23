package dev.reuss.tmdb.domain.tv.season

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvSeasonImages
import dev.reuss.tmdb.domain.tv.season.model.*
import dev.reuss.tmdb.query.AppendableResponse

/**
 * TV season responses that can be requested through TMDB's `append_to_response` parameter.
 */
enum class TvSeasonAppend(
    override val value: String,
    override val responseType: Class<*>
) : AppendableResponse {

    AGGREGATE_CREDITS("aggregate_credits", TvSeasonAggregateCredits::class.java),
    CHANGES("changes", TvSeasonChanges::class.java),
    CREDITS("credits", TvSeasonCredits::class.java),
    EXTERNAL_IDS("external_ids", ExternalIds::class.java),
    IMAGES("images", TvSeasonImages::class.java),
    TRANSLATIONS("translations", TvSeasonTranslations::class.java),
    VIDEOS("videos", TvSeasonVideos::class.java),
    WATCH_PROVIDERS("watch/providers", TvSeasonWatchProviders::class.java)
}