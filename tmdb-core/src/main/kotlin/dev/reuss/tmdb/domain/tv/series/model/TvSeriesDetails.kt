package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.company.ProductionCompany
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.genre.Genre

/**
 * Details of a TMDB TV series.
 *
 * @property adult whether the series is marked as adult
 * @property backdropPath backdrop image path
 * @property createdBy series creators
 * @property episodeRunTime episode runtimes in minutes
 * @property firstAirDate first air date
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
 * @property originCountry origin countries
 * @property originalLanguage original language
 * @property originalName original name
 * @property overview series overview
 * @property popularity popularity
 * @property posterPath poster image path
 * @property productionCompanies production companies
 * @property productionCountries production countries
 * @property seasons seasons
 * @property spokenLanguages spoken languages
 * @property status series status
 * @property tagline series tagline
 * @property type series type
 * @property voteAverage vote average
 * @property voteCount vote count
 * @property aggregateCredits appended aggregate credits
 * @property alternativeTitles appended alternative titles
 * @property changes appended changes
 * @property contentRatings appended content ratings
 * @property credits appended credits
 * @property episodeGroups appended episode groups
 * @property externalIds appended external ids
 * @property keywords appended keywords
 * @property recommendations appended recommendations
 * @property reviews appended reviews
 * @property screenedTheatrically appended theatrical screenings
 * @property similar appended similar TV series
 * @property translations appended translations
 * @property videos appended videos
 * @property watchProviders appended watch providers
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
    val watchProviders: TvSeriesWatchProviders? = null
) : TmdbModel