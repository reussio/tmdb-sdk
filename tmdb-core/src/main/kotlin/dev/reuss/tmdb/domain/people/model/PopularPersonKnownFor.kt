package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Media item a popular person is known for.
 *
 * @property adult whether the media item is marked as adult
 * @property backdropPath backdrop image path
 * @property genreIds genre ids
 * @property id TMDB media id
 * @property mediaType media type, for example movie or tv
 * @property originalLanguage original language
 * @property originalTitle original movie title
 * @property originalName original TV name
 * @property overview overview
 * @property posterPath poster image path
 * @property releaseDate movie release date
 * @property firstAirDate TV first air date
 * @property title movie title
 * @property name TV name
 * @property video whether this movie has video flag
 * @property voteAverage vote average
 * @property voteCount vote count
 */
@JvmRecord
data class PopularPersonKnownFor(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("genre_ids")
    val genreIds: List<Int> = emptyList(),
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("media_type")
    val mediaType: MediaType?,
    @all:JsonProperty("original_language")
    val originalLanguage: String?,
    @all:JsonProperty("original_title")
    val originalTitle: String?,
    @all:JsonProperty("original_name")
    val originalName: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("release_date")
    val releaseDate: String?,
    @all:JsonProperty("first_air_date")
    val firstAirDate: String?,
    @all:JsonProperty("title")
    val title: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("video")
    val video: Boolean,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
) : TmdbModel
