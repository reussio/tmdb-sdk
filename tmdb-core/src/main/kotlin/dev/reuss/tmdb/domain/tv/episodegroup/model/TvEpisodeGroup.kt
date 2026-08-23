package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel

/**
 * Episode group inside a TV episode group.
 *
 * @property id group id
 * @property name group name
 * @property order group order
 * @property episodes grouped episodes
 * @property locked whether the group is locked
 */
@JvmRecord
data class TvEpisodeGroup(
    @all:JsonProperty("id")
    val id: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("order")
    val order: Int,

    @all:JsonProperty("episodes")
    val episodes: List<TvEpisodeGroupEpisode> = emptyList(),

    @all:JsonProperty("locked")
    val locked: Boolean
) : TmdbModel
