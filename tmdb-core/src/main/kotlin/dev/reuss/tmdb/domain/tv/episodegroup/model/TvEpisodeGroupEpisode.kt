package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Episode inside a TV episode group.
 *
 * @property airDate episode air date
 * @property episodeNumber episode number
 * @property id TMDB episode id
 * @property name episode name
 * @property overview episode overview
 * @property productionCode production code
 * @property runtime runtime in minutes
 * @property seasonNumber season number
 * @property showId TMDB show id
 * @property stillPath still image path
 * @property voteAverage vote average
 * @property voteCount vote count
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
    val order: Int
) : TmdbModel