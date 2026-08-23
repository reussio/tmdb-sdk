package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Lightweight TV season representation used in TV series details.
 *
 * @property airDate season air date
 * @property episodeCount episode count
 * @property id TMDB season id
 * @property name season name
 * @property overview season overview
 * @property posterPath poster image path
 * @property seasonNumber season number
 * @property voteAverage vote average
 */
@JvmRecord
data class TvSeriesSeason(
    @all:JsonProperty("air_date")
    val airDate: String?,

    @all:JsonProperty("episode_count")
    val episodeCount: Int,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("overview")
    val overview: String?,

    @all:JsonProperty("poster_path")
    val posterPath: String?,

    @all:JsonProperty("season_number")
    val seasonNumber: Int,

    @all:JsonProperty("vote_average")
    val voteAverage: Double
) : TmdbModel