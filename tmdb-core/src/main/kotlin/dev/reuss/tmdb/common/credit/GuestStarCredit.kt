package dev.reuss.tmdb.common.credit

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Guest star credit for a TMDB TV episode.
 *
 * @property character          played character
 * @param creditId           credit id
 * @param order              credit order
 * @param adult              whether the person is marked as adult
 * @param gender             gender
 * @param id                 TMDB person id
 * @param knownForDepartment known for department
 * @param name               person name
 * @param originalName       original person name
 * @param popularity         popularity
 * @param profilePath        profile image path
 */
@JvmRecord
data class GuestStarCredit(
    @all:JsonProperty("character")
    val character: String?,

    @all:JsonProperty("credit_id")
    val creditId: String?,

    @all:JsonProperty("order")
    val order: Int?,

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
    val profilePath: String?
) : TmdbModel
