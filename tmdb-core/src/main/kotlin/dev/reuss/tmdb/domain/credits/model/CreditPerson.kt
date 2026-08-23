package dev.reuss.tmdb.domain.credits.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Person information included in a TMDB credit response.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property id TMDB person id
 * @property name person name
 * @property originalName original person name
 * @property mediaType TMDB media type discriminator, such as `movie`, `tv`, or `person`.
 * @property popularity Popularity score calculated by TMDB.
 * @property gender TMDB gender code for the person.
 * @property knownForDepartment Department the person is primarily known for.
 * @property profilePath TMDB image path for the profile image.
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
