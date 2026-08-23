package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Movie item used in paged movie list responses.
 *
 * @property adult whether the movie is marked as adult
 * @property backdropPath backdrop image path
 * @property genreIds genre ids
 * @property id TMDB movie id
 * @property originalLanguage original language
 * @property originalTitle original title
 * @property overview movie overview
 * @property popularity popularity
 * @property posterPath poster image path
 * @property releaseDate release date
 * @property title movie title
 * @property video whether the movie has video flag
 * @property voteAverage vote average
 * @property voteCount vote count
 */
@JvmRecord
data class MovieListItem(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("genre_ids")
    val genreIds: List<Int> = emptyList(),
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("original_language")
    val originalLanguage: String?,
    @all:JsonProperty("original_title")
    val originalTitle: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("popularity")
    val popularity: Double,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("release_date")
    val releaseDate: String?,
    @all:JsonProperty("title")
    val title: String?,
    @all:JsonProperty("video")
    val video: Boolean,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
) : TmdbModel
