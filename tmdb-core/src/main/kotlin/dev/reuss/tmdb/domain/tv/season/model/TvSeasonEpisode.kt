package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CrewCredit
import dev.reuss.tmdb.common.credit.GuestStarCredit

/**
 * Episode of a TMDB TV season.
 *
 * @property airDate episode air date
 * @property episodeNumber Episode number within its season.
 * @property episodeType episode type
 * @property id TMDB episode id
 * @property name episode name
 * @property overview Localized overview when available.
 * @property productionCode production code
 * @property runtime Runtime in minutes when known.
 * @property seasonNumber Season number within its TV series.
 * @property showId TMDB TV series id
 * @property stillPath TMDB image path for the episode still.
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property crew episode crew
 * @property guestStars episode guest stars
 */
@JvmRecord
data class TvSeasonEpisode(
    @all:JsonProperty("air_date")
    val airDate: String?,
    @all:JsonProperty("episode_number")
    val episodeNumber: Int,
    @all:JsonProperty("episode_type")
    val episodeType: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("production_code")
    val productionCode: String?,
    @all:JsonProperty("runtime")
    val runtime: Int?,
    @all:JsonProperty("season_number")
    val seasonNumber: Int,
    @all:JsonProperty("show_id")
    val showId: Int,
    @all:JsonProperty("still_path")
    val stillPath: String?,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("crew")
    val crew: List<CrewCredit> = emptyList(),
    @all:JsonProperty("guest_stars")
    val guestStars: List<GuestStarCredit> = emptyList(),
) : TmdbModel
