package dev.reuss.tmdb.domain.tv.episode.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CrewCredit
import dev.reuss.tmdb.common.credit.GuestStarCredit
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvEpisodeImages

/**
 * Details for a TMDB TV episode.
 *
 * @property airDate episode air date
 * @property crew episode crew
 * @property episodeNumber episode number
 * @property guestStars episode guest stars
 * @property name episode name
 * @property overview episode overview
 * @property id TMDB episode id
 * @property productionCode production code
 * @property runtime runtime in minutes
 * @property seasonNumber season number
 * @property stillPath still image path
 * @property voteAverage vote average
 * @property voteCount vote count
 * @property changes appended changes
 * @property credits appended credits
 * @property externalIds appended external ids
 * @property images appended images
 * @property translations appended translations
 * @property videos appended videos
 */
@JvmRecord
data class TvEpisodeDetails(
    @all:JsonProperty("air_date")
    val airDate: String?,
    @all:JsonProperty("crew")
    val crew: List<CrewCredit> = emptyList(),
    @all:JsonProperty("episode_number")
    val episodeNumber: Int,
    @all:JsonProperty("guest_stars")
    val guestStars: List<GuestStarCredit> = emptyList(),
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("production_code")
    val productionCode: String?,
    @all:JsonProperty("runtime")
    val runtime: Int?,
    @all:JsonProperty("season_number")
    val seasonNumber: Int,
    @all:JsonProperty("still_path")
    val stillPath: String?,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("changes")
    val changes: TvEpisodeChanges? = null,
    @all:JsonProperty("credits")
    val credits: TvEpisodeCredits? = null,
    @all:JsonProperty("external_ids")
    val externalIds: ExternalIds? = null,
    @all:JsonProperty("images")
    val images: TvEpisodeImages? = null,
    @all:JsonProperty("translations")
    val translations: TvEpisodeTranslations? = null,
    @all:JsonProperty("videos")
    val videos: TvEpisodeVideos? = null,
) : TmdbModel
