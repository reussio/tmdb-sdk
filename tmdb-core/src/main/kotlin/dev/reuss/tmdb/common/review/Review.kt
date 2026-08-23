package dev.reuss.tmdb.common.review

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Review item for a TMDB resource.
 *
 * @property author        review author
 * @property authorDetails review author details
 * @property content       review content
 * @property createdAt     creation timestamp
 * @property id            review id
 * @param updatedAt     update timestamp
 * @param url           review URL
 */
@JvmRecord
data class Review(
    @all:JsonProperty("author")
    val author: String?,

    @all:JsonProperty("author_details")
    val authorDetails: ReviewAuthorDetails?,

    @all:JsonProperty("content")
    val content: String?,

    @all:JsonProperty("created_at")
    val createdAt: String?,

    @all:JsonProperty("id")
    val id: String?,

    @all:JsonProperty("updated_at")
    val updatedAt: String?,

    @all:JsonProperty("url")
    val url: String?
) : TmdbModel
