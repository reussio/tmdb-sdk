package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate cast credit for a TV season.
 *
 * @property adult whether the person is marked as adult
 * @property gender gender
 * @property id TMDB person id
 * @property knownForDepartment known for department
 * @property name person name
 * @property originalName original person name
 * @property popularity popularity
 * @property profilePath profile image path
 * @property roles roles in this season
 * @property totalEpisodeCount total episode count
 * @property order cast order
 */
@JvmRecord
data class TvSeasonAggregateCastCredit(
    @all:JsonProperty("adult")
    val adult: Boolean,

    @all:JsonProperty("gender")
    val gender: Int,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("known_for_department")
    val knownForDepartment: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("original_name")
    val originalName: String?,

    @all:JsonProperty("popularity")
    val popularity: Double,

    @all:JsonProperty("profile_path")
    val profilePath: String?,

    @all:JsonProperty("roles")
    val roles: List<TvSeasonAggregateCastRole> = emptyList(),

    @all:JsonProperty("total_episode_count")
    val totalEpisodeCount: Int,

    @all:JsonProperty("order")
    val order: Int
) : TmdbModel