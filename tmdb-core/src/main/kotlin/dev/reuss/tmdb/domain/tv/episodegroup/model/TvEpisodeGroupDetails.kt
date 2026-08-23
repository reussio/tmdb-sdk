package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Details for a TMDB TV episode group.
 *
 * @property description episode group description
 * @property episodeCount Number of associated episodes.
 * @property groupCount total group count
 * @property groups episode groups
 * @property id TMDB episode group id
 * @property name episode group name
 * @property network network
 * @property type episode group type value
 * @property episodeGroupType resolved episode group type
 */
@JvmRecord
data class TvEpisodeGroupDetails(
    @all:JsonProperty("description")
    val description: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
    @all:JsonProperty("group_count")
    val groupCount: Int,
    @all:JsonProperty("groups")
    val groups: List<TvEpisodeGroup> = emptyList(),
    @all:JsonProperty("id")
    val id: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("network")
    val network: TvEpisodeGroupNetwork?,
    @all:JsonProperty("type")
    val type: TvEpisodeGroupType,
) : TmdbModel
