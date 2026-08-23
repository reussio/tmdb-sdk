package dev.reuss.tmdb.domain.trending.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Movie returned by TMDB movie trending.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property id TMDB movie id
 * @property title localized movie title
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalTitle original movie title
 * @property overview Localized overview when available.
 * @property posterPath TMDB image path for the poster.
 * @property mediaType TMDB media type discriminator, such as `movie`, `tv`, or `person`.
 * @property genreIds TMDB genre identifiers assigned to the resource.
 * @property popularity Popularity score calculated by TMDB.
 * @property releaseDate Movie release date in `YYYY-MM-DD` format when known.
 * @property video Whether TMDB marks the movie as having video content.
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 */
@JvmRecord
data class TrendingMovie(
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
