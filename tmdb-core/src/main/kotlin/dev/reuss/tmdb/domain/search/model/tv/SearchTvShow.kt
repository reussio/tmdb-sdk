package dev.reuss.tmdb.domain.search.model.tv

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV show returned by TMDB TV search.
 *
 * @property adult whether the TV show is marked as adult
 * @property backdropPath backdrop image path
 * @property genreIds genre ids
 * @property id TMDB TV show id
 * @property originCountry origin countries
 * @property originalLanguage original language code
 * @property originalName original TV show name
 * @property overview TV show overview
 * @property popularity TV show popularity
 * @property posterPath poster image path
 * @property firstAirDate first air date
 * @property name localized TV show name
 * @property voteAverage vote average
 * @property voteCount vote count
 */
@JvmRecord
data class SearchTvShow(
    @all:JsonProperty("adult")
    val adult: Boolean,

    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,

    @all:JsonProperty("genre_ids")
    val genreIds: List<Int> = emptyList(),

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("origin_country")
    val originCountry: List<String> = emptyList(),

    @all:JsonProperty("original_language")
    val originalLanguage: String?,

    @all:JsonProperty("original_name")
    val originalName: String?,

    @all:JsonProperty("overview")
    val overview: String?,

    @all:JsonProperty("popularity")
    val popularity: Double,

    @all:JsonProperty("poster_path")
    val posterPath: String?,

    @all:JsonProperty("first_air_date")
    val firstAirDate: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("vote_average")
    val voteAverage: Double,

    @all:JsonProperty("vote_count")
    val voteCount: Int
) : TmdbModel