package dev.reuss.tmdb.common.credit

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Cast credit for a TMDB resource.
 *
 * @property adult              whether the person is marked as adult
 * @property gender             gender
 * @property id                 TMDB person id
 * @property knownForDepartment known for department
 * @property name               person name
 * @property originalName       original person name
 * @property popularity         popularity
 * @property profilePath        profile image path
 * @property castId             cast id, if provided by the endpoint
 * @property character          character name
 * @property creditId           credit id
 * @property order              cast order
 */
@JvmRecord
data class CastCredit(
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

    @all:JsonProperty("cast_id")
    val castId: Int?,

    @all:JsonProperty("character")
    val character: String?,

    @all:JsonProperty("credit_id")
    val creditId: String?,

    @all:JsonProperty("order")
    val order: Int?
) : TmdbModel
