package dev.reuss.tmdb.common.credit

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Crew credit for a TMDB resource.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property gender TMDB gender code for the person.
 * @property id                 TMDB person id
 * @property knownForDepartment Department the person is primarily known for.
 * @property name               person name
 * @property originalName       original person name
 * @property popularity Popularity score calculated by TMDB.
 * @property profilePath TMDB image path for the profile image.
 * @property creditId           credit id
 * @property department         department
 * @property job                job
 */
@JvmRecord
data class CrewCredit(
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
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("job")
    val job: String?,
) : TmdbModel
