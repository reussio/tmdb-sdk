package dev.reuss.tmdb.domain.discover.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV show summary returned by TMDB TV discovery.
 *
 * @property backdropPath backdrop image path
 * @property firstAirDate first air date
 * @property genreIds genre ids
 * @property id TMDB TV show id
 * @property name localized TV show name
 * @property originCountry origin countries
 * @property originalLanguage original language code
 * @property originalName original TV show name
 * @property overview TV show overview
 * @property popularity TV show popularity
 * @property posterPath poster image path
 * @property voteAverage vote average
 * @property voteCount vote count
 */
@JvmRecord
data class DiscoverTvShow(
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,

    @all:JsonProperty("first_air_date")
    val firstAirDate: String?,

    @all:JsonProperty("genre_ids")
    val genreIds: List<Int> = emptyList(),

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("name")
    val name: String?,

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

    @all:JsonProperty("vote_average")
    val voteAverage: Double,

    @all:JsonProperty("vote_count")
    val voteCount: Int
) : TmdbModel