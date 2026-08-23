package dev.reuss.tmdb.domain.reviews.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.review.ReviewAuthorDetails
import dev.reuss.tmdb.value.media.MediaType

/**
 * TMDB review details.
 *
 * @property id TMDB review id
 * @property author review author name
 * @property authorDetails review author details
 * @property content review content
 * @property createdAt creation timestamp
 * @property iso6391 ISO 639-1 language code
 * @property mediaId related movie or TV show id
 * @property mediaTitle related movie or TV show title
 * @property mediaType related media type, for example `movie` or `tv`
 * @property updatedAt update timestamp
 * @property url TMDB review URL
 */
@JvmRecord
data class Review(
    @all:JsonProperty("id")
    val id: String?,

    @all:JsonProperty("author")
    val author: String?,

    @all:JsonProperty("author_details")
    val authorDetails: ReviewAuthorDetails?,

    @all:JsonProperty("content")
    val content: String?,

    @all:JsonProperty("created_at")
    val createdAt: String?,

    @all:JsonProperty("iso_639_1")
    val iso6391: String?,

    @all:JsonProperty("media_id")
    val mediaId: Int,

    @all:JsonProperty("media_title")
    val mediaTitle: String?,

    @all:JsonProperty("media_type")
    val mediaType: MediaType?,

    @all:JsonProperty("updated_at")
    val updatedAt: String?,

    @all:JsonProperty("url")
    val url: String?
) : TmdbModel