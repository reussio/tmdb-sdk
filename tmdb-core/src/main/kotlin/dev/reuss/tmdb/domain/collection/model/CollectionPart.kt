package dev.reuss.tmdb.domain.collection.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Movie that is part of a TMDB collection.
 *
 * @property adult whether the movie is adult content
 * @property backdropPath backdrop path
 * @property id movie id
 * @property name movie name
 * @property originalName original movie name
 * @property overview movie overview
 * @property posterPath poster path
 * @property mediaType media type
 * @property originalLanguage original language
 * @property genreIds genre ids
 * @property popularity popularity score
 * @property releaseDate release date
 * @property video whether this is a video
 * @property voteAverage vote average
 * @property voteCount vote count
 */
@JvmRecord
data class CollectionPart(
    @all:JsonProperty("adult")
    val adult: Boolean,

    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("original_name")
    val originalName: String?,

    @all:JsonProperty("overview")
    val overview: String?,

    @all:JsonProperty("poster_path")
    val posterPath: String?,

    @all:JsonProperty("media_type")
    val mediaType: String?,

    @all:JsonProperty("original_language")
    val originalLanguage: String?,

    @all:JsonProperty("genre_ids")
    val genreIds: List<Int> = emptyList(),

    @all:JsonProperty("popularity")
    val popularity: Double,

    @all:JsonProperty("release_date")
    val releaseDate: String?,

    @all:JsonProperty("video")
    val video: Boolean,

    @all:JsonProperty("vote_average")
    val voteAverage: Double,

    @all:JsonProperty("vote_count")
    val voteCount: Int
) : TmdbModel