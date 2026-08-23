package dev.reuss.tmdb.domain.trending.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * TV series returned by TMDB TV trending.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property id TMDB TV series id
 * @property name localized TV series name
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalName original TV series name
 * @property overview Localized overview when available.
 * @property posterPath TMDB image path for the poster.
 * @property mediaType TMDB media type discriminator, such as `movie`, `tv`, or `person`.
 * @property genreIds TMDB genre identifiers assigned to the resource.
 * @property popularity Popularity score calculated by TMDB.
 * @property firstAirDate First air date in `YYYY-MM-DD` format when known.
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property originCountry ISO 3166-1 codes for the resource's countries of origin.
 */
@JvmRecord
data class TrendingTvShow(
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
    val originCountry: List<String> = emptyList(),
) : TmdbModel
