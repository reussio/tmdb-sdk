package dev.reuss.tmdb.domain.search.model.person

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Person returned by TMDB person search.
 *
 * @property adult whether the person is marked as adult
 * @property gender gender value returned by TMDB
 * @property id TMDB person id
 * @property knownForDepartment known department
 * @property name person name
 * @property originalName original person name
 * @property popularity person popularity
 * @property profilePath profile image path
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
