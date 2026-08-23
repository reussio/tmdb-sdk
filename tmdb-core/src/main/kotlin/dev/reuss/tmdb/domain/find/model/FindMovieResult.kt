package dev.reuss.tmdb.domain.find.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Movie result returned by TMDB find.
 *
 * @property adult whether the movie is marked as adult
 * @property backdropPath backdrop image path
 * @property id TMDB movie id
 * @property title movie title
 * @property originalLanguage original language
 * @property originalTitle original title
 * @property overview movie overview
 * @property posterPath poster image path
 * @property mediaType media type discriminator
 * @property genreIds genre ids
 * @property popularity popularity
 * @property releaseDate release date
 * @property video whether the movie has video flag
 * @property voteAverage vote average
 * @property voteCount vote count
 */
@JvmRecord
data class FindMovieResult(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("title")
    val title: String?,
    @all:JsonProperty("original_language")
    val originalLanguage: String?,
    @all:JsonProperty("original_title")
    val originalTitle: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("media_type")
    val mediaType: MediaType?,
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
    val voteCount: Int,
) : TmdbModel
