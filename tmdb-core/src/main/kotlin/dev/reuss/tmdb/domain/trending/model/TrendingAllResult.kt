package dev.reuss.tmdb.domain.trending.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Result item returned by TMDB trending all.
 *
 * This model supports movie, TV and person results. Fields that do not
 * apply to the concrete media type may be `null` or empty.
 *
 * @property adult whether the result is marked as adult
 * @property backdropPath backdrop image path
 * @property id TMDB resource id
 * @property title movie title
 * @property originalTitle original movie title
 * @property name TV show or person name
 * @property originalName original TV show or person name
 * @property originalLanguage original language code
 * @property overview overview
 * @property posterPath poster image path
 * @property profilePath person profile image path
 * @property mediaType media type, for example `movie`, `tv` or `person`
 * @property genreIds genre ids
 * @property popularity popularity
 * @property releaseDate movie release date
 * @property firstAirDate TV first air date
 * @property video whether the movie has video content
 * @property voteAverage vote average
 * @property voteCount vote count
 * @property originCountry TV origin countries
 */
@JvmRecord
data class TrendingAllResult(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("title")
    val title: String?,
    @all:JsonProperty("original_title")
    val originalTitle: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("original_name")
    val originalName: String?,
    @all:JsonProperty("original_language")
    val originalLanguage: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("profile_path")
    val profilePath: String?,
    @all:JsonProperty("media_type")
    val mediaType: MediaType?,
    @all:JsonProperty("genre_ids")
    val genreIds: List<Int> = emptyList(),
    @all:JsonProperty("popularity")
    val popularity: Double,
    @all:JsonProperty("release_date")
    val releaseDate: String?,
    @all:JsonProperty("first_air_date")
    val firstAirDate: String?,
    @all:JsonProperty("video")
    val video: Boolean,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("origin_country")
    val originCountry: List<String> = emptyList(),
) : TmdbModel
