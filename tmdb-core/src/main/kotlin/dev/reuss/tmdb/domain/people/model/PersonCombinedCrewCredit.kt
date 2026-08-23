package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * Combined crew credit for a TMDB person.
 *
 * This model supports both movie and TV credits. Fields that do not apply
 * to the concrete media type may be `null` or empty.
 *
 * @property adult whether the media is marked as adult
 * @property backdropPath backdrop image path
 * @property genreIds genre ids
 * @property id TMDB media id
 * @property originalLanguage original language code
 * @property originalTitle original movie title
 * @property originalName original TV show name
 * @property overview overview
 * @property popularity popularity
 * @property posterPath poster image path
 * @property releaseDate movie release date
 * @property firstAirDate TV first air date
 * @property title movie title
 * @property name TV show name
 * @property video whether the movie has video content
 * @property voteAverage vote average
 * @property voteCount vote count
 * @property originCountry TV origin countries
 * @property creditId TMDB credit id
 * @property department crew department
 * @property job crew job
 * @property episodeCount TV episode count
 * @property mediaType media type
 */
@JvmRecord
data class PersonCombinedCrewCredit(
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
    @all:JsonProperty("original_name")
    val originalName: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("popularity")
    val popularity: Double,
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
    @all:JsonProperty("origin_country")
    val originCountry: List<String> = emptyList(),
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("job")
    val job: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
    @all:JsonProperty("media_type")
    val mediaType: MediaType?,
) : TmdbModel
