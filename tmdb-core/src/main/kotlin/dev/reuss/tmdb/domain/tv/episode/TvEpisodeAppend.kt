package dev.reuss.tmdb.domain.tv.episode

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvEpisodeImages
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeChanges
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeCredits
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeTranslations
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeVideos
import dev.reuss.tmdb.query.AppendableResponse

/**
 * TV episode responses that can be requested through TMDB's `append_to_response` parameter.
 */
enum class TvEpisodeAppend(
    override val value: String,
    override val responseType: Class<*>
) : AppendableResponse {

    CHANGES("changes", TvEpisodeChanges::class.java),
    CREDITS("credits", TvEpisodeCredits::class.java),
    EXTERNAL_IDS("external_ids", ExternalIds::class.java),
    IMAGES("images", TvEpisodeImages::class.java),
    TRANSLATIONS("translations", TvEpisodeTranslations::class.java),
    VIDEOS("videos", TvEpisodeVideos::class.java)
}