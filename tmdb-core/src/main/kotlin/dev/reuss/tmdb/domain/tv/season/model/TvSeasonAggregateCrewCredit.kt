package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate crew credit for a TV season.
 *
 * @property adult whether the person is marked as adult
 * @property gender gender
 * @property id TMDB person id
 * @property knownForDepartment known for department
 * @property name person name
 * @property originalName original person name
 * @property popularity popularity
 * @property profilePath profile image path
 * @property jobs jobs in this season
 * @property department department
 * @property totalEpisodeCount total episode count
 */
@JvmRecord
data class TvSeasonAggregateCrewCredit(
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
    @all:JsonProperty("jobs")
    val jobs: List<TvSeasonAggregateCrewJob> = emptyList(),
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("total_episode_count")
    val totalEpisodeCount: Int,
) : TmdbModel
