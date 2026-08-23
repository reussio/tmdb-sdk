package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupType

/**
 * Episode group for a TMDB TV series.
 *
 * @property description group description
 * @property episodeCount episode count
 * @property groupCount group count
 * @property id TMDB episode group id
 * @property name group name
 * @property network related network
 * @property type group type
 */
@JvmRecord
data class TvSeriesEpisodeGroup(
    @all:JsonProperty("description")
    val description: String?,

    @all:JsonProperty("episode_count")
    val episodeCount: Int,

    @all:JsonProperty("group_count")
    val groupCount: Int,

    @all:JsonProperty("id")
    val id: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("network")
    val network: TvSeriesNetwork?,

    @all:JsonProperty("type")
    val type: TvEpisodeGroupType
) : TmdbModel