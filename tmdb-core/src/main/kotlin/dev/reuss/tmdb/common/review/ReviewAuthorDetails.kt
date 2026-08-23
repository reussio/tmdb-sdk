package dev.reuss.tmdb.common.review

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Author details for a TMDB review.
 *
 * @property name       author display name
 * @property username   author username
 * @property avatarPath author avatar path
 * @property rating     author rating
 */
@JvmRecord
data class ReviewAuthorDetails(
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("username")
    val username: String?,
    @all:JsonProperty("avatar_path")
    val avatarPath: String?,
    @all:JsonProperty("rating")
    val rating: Double?,
) : TmdbModel
