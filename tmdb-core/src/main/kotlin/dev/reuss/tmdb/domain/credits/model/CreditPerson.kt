package dev.reuss.tmdb.domain.credits.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Person information included in a TMDB credit response.
 *
 * @property adult whether the person is marked as adult
 * @property id TMDB person id
 * @property name person name
 * @property originalName original person name
 * @property mediaType media type, usually `person`
 * @property popularity person popularity
 * @property gender gender value returned by TMDB
 * @property knownForDepartment known department
 * @property profilePath profile image path
 */
@JvmRecord
data class CreditPerson(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("original_name")
    val originalName: String?,
    @all:JsonProperty("media_type")
    val mediaType: MediaType?,
    @all:JsonProperty("popularity")
    val popularity: Double,
    @all:JsonProperty("gender")
    val gender: Int,
    @all:JsonProperty("known_for_department")
    val knownForDepartment: String?,
    @all:JsonProperty("profile_path")
    val profilePath: String?,
) : TmdbModel
