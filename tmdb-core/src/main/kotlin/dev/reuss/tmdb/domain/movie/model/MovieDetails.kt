package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.company.ProductionCompany
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.genre.Genre
import dev.reuss.tmdb.common.image.MovieImages

/**
 * Details for a TMDB movie.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property belongsToCollection collection this movie belongs to
 * @property budget movie budget
 * @property genres movie genres
 * @property homepage movie homepage
 * @property id TMDB movie id
 * @property imdbId IMDb id
 * @property originCountry ISO 3166-1 codes for the resource's countries of origin.
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalTitle original title
 * @property overview Localized overview when available.
 * @property popularity Popularity score calculated by TMDB.
 * @property posterPath TMDB image path for the poster.
 * @property productionCompanies production companies
 * @property productionCountries production countries
 * @property releaseDate Movie release date in `YYYY-MM-DD` format when known.
 * @property revenue movie revenue
 * @property runtime Runtime in minutes when known.
 * @property spokenLanguages spoken languages
 * @property status movie status
 * @property tagline movie tagline
 * @property title movie title
 * @property video Whether TMDB marks the movie as having video content.
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property alternativeTitles Response appended through `append_to_response` when requested.
 * @property changes Response appended through `append_to_response` when requested.
 * @property credits Response appended through `append_to_response` when requested.
 * @property externalIds Response appended through `append_to_response` when requested.
 * @property images Response appended through `append_to_response` when requested.
 * @property keywords Response appended through `append_to_response` when requested.
 * @property recommendations Response appended through `append_to_response` when requested.
 * @property releaseDates Response appended through `append_to_response` when requested.
 * @property reviews Response appended through `append_to_response` when requested.
 * @property similar Response appended through `append_to_response` when requested.
 * @property translations Response appended through `append_to_response` when requested.
 * @property videos Response appended through `append_to_response` when requested.
 * @property watchProviders Response appended through `append_to_response` when requested.
 */
@JvmRecord
data class MovieDetails(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("belongs_to_collection")
    val belongsToCollection: MovieCollection?,
    @all:JsonProperty("budget")
    val budget: Long,
    @all:JsonProperty("genres")
    val genres: List<Genre> = emptyList(),
    @all:JsonProperty("homepage")
    val homepage: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("imdb_id")
    val imdbId: String?,
    @all:JsonProperty("origin_country")
    val originCountry: List<String> = emptyList(),
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
    @all:JsonProperty("production_companies")
    val productionCompanies: List<ProductionCompany> = emptyList(),
    @all:JsonProperty("production_countries")
    val productionCountries: List<MovieProductionCountry> = emptyList(),
    @all:JsonProperty("release_date")
    val releaseDate: String?,
    @all:JsonProperty("revenue")
    val revenue: Long,
    @all:JsonProperty("runtime")
    val runtime: Int?,
    @all:JsonProperty("spoken_languages")
    val spokenLanguages: List<MovieSpokenLanguage> = emptyList(),
    @all:JsonProperty("status")
    val status: String?,
    @all:JsonProperty("tagline")
    val tagline: String?,
    @all:JsonProperty("title")
    val title: String?,
    @all:JsonProperty("video")
    val video: Boolean,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("alternative_titles")
    val alternativeTitles: MovieAlternativeTitles? = null,
    @all:JsonProperty("changes")
    val changes: MovieChanges? = null,
    @all:JsonProperty("credits")
    val credits: MovieCredits? = null,
    @all:JsonProperty("external_ids")
    val externalIds: ExternalIds? = null,
    @all:JsonProperty("images")
    val images: MovieImages? = null,
    @all:JsonProperty("keywords")
    val keywords: MovieKeywords? = null,
    @all:JsonProperty("recommendations")
    val recommendations: MovieRecommendations? = null,
    @all:JsonProperty("release_dates")
    val releaseDates: MovieReleaseDates? = null,
    @all:JsonProperty("reviews")
    val reviews: MovieReviews? = null,
    @all:JsonProperty("similar")
    val similar: SimilarMovies? = null,
    @all:JsonProperty("translations")
    val translations: MovieTranslations? = null,
    @all:JsonProperty("videos")
    val videos: MovieVideos? = null,
    @all:JsonProperty("watch/providers")
    val watchProviders: MovieWatchProviders? = null,
) : TmdbModel
