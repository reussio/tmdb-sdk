package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.company.ProductionCompany
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.genre.Genre

/**
 * Details of a TMDB TV series.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property createdBy series creators
 * @property episodeRunTime episode runtimes in minutes
 * @property firstAirDate First air date in `YYYY-MM-DD` format when known.
 * @property genres series genres
 * @property homepage series homepage
 * @property id TMDB TV series id
 * @property inProduction whether the series is in production
 * @property languages languages used by the series
 * @property lastAirDate last air date
 * @property lastEpisodeToAir last aired episode
 * @property name series name
 * @property nextEpisodeToAir next scheduled episode
 * @property networks networks
 * @property numberOfEpisodes episode count
 * @property numberOfSeasons season count
 * @property originCountry ISO 3166-1 codes for the resource's countries of origin.
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalName original name
 * @property overview Localized overview when available.
 * @property popularity Popularity score calculated by TMDB.
 * @property posterPath TMDB image path for the poster.
 * @property productionCompanies production companies
 * @property productionCountries production countries
 * @property seasons seasons
 * @property spokenLanguages spoken languages
 * @property status series status
 * @property tagline series tagline
 * @property type series type
 * @property voteAverage Average user rating reported by TMDB.
 * @property voteCount Number of user ratings reported by TMDB.
 * @property aggregateCredits Response appended through `append_to_response` when requested.
 * @property alternativeTitles Response appended through `append_to_response` when requested.
 * @property changes Response appended through `append_to_response` when requested.
 * @property contentRatings Response appended through `append_to_response` when requested.
 * @property credits Response appended through `append_to_response` when requested.
 * @property episodeGroups Response appended through `append_to_response` when requested.
 * @property externalIds Response appended through `append_to_response` when requested.
 * @property keywords Response appended through `append_to_response` when requested.
 * @property recommendations Response appended through `append_to_response` when requested.
 * @property reviews Response appended through `append_to_response` when requested.
 * @property screenedTheatrically Response appended through `append_to_response` when requested.
 * @property similar Response appended through `append_to_response` when requested.
 * @property translations Response appended through `append_to_response` when requested.
 * @property videos Response appended through `append_to_response` when requested.
 * @property watchProviders Response appended through `append_to_response` when requested.
 */
@JvmRecord
data class TvSeriesDetails(
    @all:JsonProperty("adult")
    val adult: Boolean,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("created_by")
    val createdBy: List<TvSeriesCreator> = emptyList(),
    @all:JsonProperty("episode_run_time")
    val episodeRunTime: List<Int> = emptyList(),
    @all:JsonProperty("first_air_date")
    val firstAirDate: String?,
    @all:JsonProperty("genres")
    val genres: List<Genre> = emptyList(),
    @all:JsonProperty("homepage")
    val homepage: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("in_production")
    val inProduction: Boolean,
    @all:JsonProperty("languages")
    val languages: List<String> = emptyList(),
    @all:JsonProperty("last_air_date")
    val lastAirDate: String?,
    @all:JsonProperty("last_episode_to_air")
    val lastEpisodeToAir: TvSeriesEpisode?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("next_episode_to_air")
    val nextEpisodeToAir: TvSeriesEpisode?,
    @all:JsonProperty("networks")
    val networks: List<TvSeriesNetwork> = emptyList(),
    @all:JsonProperty("number_of_episodes")
    val numberOfEpisodes: Int,
    @all:JsonProperty("number_of_seasons")
    val numberOfSeasons: Int,
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
    @all:JsonProperty("production_companies")
    val productionCompanies: List<ProductionCompany> = emptyList(),
    @all:JsonProperty("production_countries")
    val productionCountries: List<TvSeriesProductionCountry> = emptyList(),
    @all:JsonProperty("seasons")
    val seasons: List<TvSeriesSeason> = emptyList(),
    @all:JsonProperty("spoken_languages")
    val spokenLanguages: List<TvSeriesSpokenLanguage> = emptyList(),
    @all:JsonProperty("status")
    val status: String?,
    @all:JsonProperty("tagline")
    val tagline: String?,
    @all:JsonProperty("type")
    val type: String?,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("aggregate_credits")
    val aggregateCredits: TvSeriesAggregateCredits? = null,
    @all:JsonProperty("alternative_titles")
    val alternativeTitles: TvSeriesAlternativeTitles? = null,
    @all:JsonProperty("changes")
    val changes: TvSeriesChanges? = null,
    @all:JsonProperty("content_ratings")
    val contentRatings: TvSeriesContentRatings? = null,
    @all:JsonProperty("credits")
    val credits: TvSeriesCredits? = null,
    @all:JsonProperty("episode_groups")
    val episodeGroups: TvSeriesEpisodeGroups? = null,
    @all:JsonProperty("external_ids")
    val externalIds: ExternalIds? = null,
    @all:JsonProperty("keywords")
    val keywords: TvSeriesKeywords? = null,
    @all:JsonProperty("recommendations")
    val recommendations: TvSeriesRecommendations? = null,
    @all:JsonProperty("reviews")
    val reviews: TvSeriesReviews? = null,
    @all:JsonProperty("screened_theatrically")
    val screenedTheatrically: TvSeriesScreenedTheatrically? = null,
    @all:JsonProperty("similar")
    val similar: TvSeriesSimilar? = null,
    @all:JsonProperty("translations")
    val translations: TvSeriesTranslations? = null,
    @all:JsonProperty("videos")
    val videos: TvSeriesVideos? = null,
    @all:JsonProperty("watch/providers")
    val watchProviders: TvSeriesWatchProviders? = null,
) : TmdbModel
