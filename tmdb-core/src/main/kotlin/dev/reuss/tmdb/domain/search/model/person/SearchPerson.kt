package dev.reuss.tmdb.domain.search.model.person

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Person returned by TMDB person search.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property gender TMDB gender code for the person.
 * @property id TMDB person id
 * @property knownForDepartment Department the person is primarily known for.
 * @property name person name
 * @property originalName original person name
 * @property popularity Popularity score calculated by TMDB.
 * @property profilePath TMDB image path for the profile image.
 * @property knownFor known movie or TV results
 */
@JvmRecord
data class SearchPerson(
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
    @all:JsonProperty("known_for")
    val knownFor: List<SearchPersonKnownFor> = emptyList(),
) : TmdbModel
