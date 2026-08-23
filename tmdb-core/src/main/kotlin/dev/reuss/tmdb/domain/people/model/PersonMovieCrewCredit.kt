package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Movie crew credit for a TMDB person.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property genreIds TMDB genre identifiers assigned to the resource.
 * @property id TMDB movie id
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalTitle original movie title
 * @property overview Localized overview when available.
 * @property popularity Popularity score calculated by TMDB.
 * @property posterPath TMDB image path for the poster.
 * @property releaseDate Movie release date in `YYYY-MM-DD` format when known.
 * @property title movie title
 * @property video Whether TMDB marks the movie as having video content.
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property creditId TMDB credit id
 * @property department crew department
 * @property job crew job
 */
@JvmRecord
data class PersonMovieCrewCredit(
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
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("job")
    val job: String?,
) : TmdbModel
