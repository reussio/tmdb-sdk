package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Recommended TV series.
 *
 * @property adult whether the TV series is marked as adult
 * @property backdropPath backdrop image path
 * @property id TMDB TV series id
 * @property name TV series name
 * @property originalLanguage original language
 * @property originalName original TV series name
 * @property overview overview
 * @property posterPath poster image path
 * @property mediaType media type
 * @property genreIds genre ids
 * @property popularity popularity
 * @property firstAirDate first air date
 * @property voteAverage vote average
 * @property voteCount vote count
 * @property originCountry origin countries
 */
@JvmRecord
data class TvSeriesRecommendation(
    @all:JsonProperty("adult")
    val adult: Boolean,

    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("original_language")
    val originalLanguage: String?,

    @all:JsonProperty("original_name")
    val originalName: String?,

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

    @all:JsonProperty("first_air_date")
    val firstAirDate: String?,

    @all:JsonProperty("vote_average")
    val voteAverage: Double,

    @all:JsonProperty("vote_count")
    val voteCount: Int,

    @all:JsonProperty("origin_country")
    val originCountry: List<String> = emptyList()
) : TmdbModel