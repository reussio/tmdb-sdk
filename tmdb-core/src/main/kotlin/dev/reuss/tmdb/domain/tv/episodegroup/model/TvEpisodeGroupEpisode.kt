package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Episode inside a TV episode group.
 *
 * @property airDate episode air date
 * @property episodeNumber Episode number within its season.
 * @property id TMDB episode id
 * @property name episode name
 * @property overview Localized overview when available.
 * @property productionCode production code
 * @property runtime Runtime in minutes when known.
 * @property seasonNumber Season number within its TV series.
 * @property showId TMDB show id
 * @property stillPath TMDB image path for the episode still.
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property order episode order inside the group
 */
@JvmRecord
data class TvEpisodeGroupEpisode(
    @all:JsonProperty("air_date")
    val airDate: String?,
    @all:JsonProperty("episode_number")
    val episodeNumber: Int,
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
    @all:JsonProperty("order")
    val order: Int,
) : TmdbModel
