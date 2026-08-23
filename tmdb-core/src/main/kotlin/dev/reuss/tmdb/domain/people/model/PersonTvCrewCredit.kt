package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV crew credit for a TMDB person.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property genreIds TMDB genre identifiers assigned to the resource.
 * @property id TMDB TV series id
 * @property originCountry ISO 3166-1 codes for the resource's countries of origin.
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalName original TV series name
 * @property overview Localized overview when available.
 * @property popularity Popularity score calculated by TMDB.
 * @property posterPath TMDB image path for the poster.
 * @property firstAirDate First air date in `YYYY-MM-DD` format when known.
 * @property name TV series name
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property creditId TMDB credit id
 * @property department crew department
 * @property episodeCount Number of associated episodes.
 * @property job crew job
 */
@JvmRecord
data class PersonTvCrewCredit(
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
    val voteCount: Int,
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
    @all:JsonProperty("job")
    val job: String?,
) : TmdbModel
