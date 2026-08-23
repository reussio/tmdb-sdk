package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Lightweight TV episode representation used in TV series details.
 *
 * @property id TMDB episode id
 * @property name episode name
 * @property overview episode overview
 * @property voteAverage vote average
 * @property voteCount vote count
 * @property airDate episode air date
 * @property episodeNumber episode number
 * @property productionCode production code
 * @property runtime runtime in minutes
 * @property seasonNumber season number
 * @property showId TMDB TV series id
 * @property stillPath still image path
 */
@JvmRecord
data class TvSeriesEpisode(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("air_date")
    val airDate: String?,
    @all:JsonProperty("episode_number")
    val episodeNumber: Int,
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
) : TmdbModel
