package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Popular TMDB person.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property gender TMDB gender code for the person.
 * @property id TMDB person id
 * @property knownFor known media
 * @property knownForDepartment Department the person is primarily known for.
 * @property name person name
 * @property popularity Popularity score calculated by TMDB.
 * @property profilePath TMDB image path for the profile image.
 */
@JvmRecord
data class PopularPerson(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("gender")
    val gender: Int,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("known_for")
    val knownFor: List<PopularPersonKnownFor> = emptyList(),
    @all:JsonProperty("known_for_department")
    val knownForDepartment: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("popularity")
    val popularity: Double,
    @all:JsonProperty("profile_path")
    val profilePath: String?,
) : TmdbModel
