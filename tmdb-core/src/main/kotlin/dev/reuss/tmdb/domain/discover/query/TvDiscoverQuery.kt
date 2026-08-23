package dev.reuss.tmdb.domain.discover.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.time.LocalDate

/**
 * Builds filters for TMDB TV-series discovery.
 *
 * All filters are optional. TMDB ID expressions generally use a comma for logical AND and a pipe
 * for logical OR. Watch-provider filters should be paired with [watchRegion].
 */
class TvDiscoverQuery private constructor() : PagedQuery<TvDiscoverQuery> {
    private var airDateGte: LocalDate? = null
    private var airDateLte: LocalDate? = null

    private var firstAirDateYear: Int? = null
    private var firstAirDateGte: LocalDate? = null
    private var firstAirDateLte: LocalDate? = null

    private var includeAdult: Boolean? = null
    private var includeNullFirstAirDates: Boolean? = null

    private var language: Language? = null
    private var page: Int? = null

    private var screenedTheatrically: Boolean? = null

    private var sortBy: TvDiscoverSortBy? = null

    private var timezone: String? = null

    private var voteAverageGte: Double? = null
    private var voteAverageLte: Double? = null
    private var voteCountGte: Double? = null
    private var voteCountLte: Double? = null

    private var watchRegion: Region? = null

    private var withCompanies: String? = null
    private var withGenres: String? = null
    private var withKeywords: String? = null
    private var withNetworks: Int? = null
    private var withOriginCountry: String? = null
    private var withOriginalLanguage: String? = null

    private var withRuntimeGte: Int? = null
    private var withRuntimeLte: Int? = null

    private var withStatus: String? = null
    private var withWatchMonetizationTypes: String? = null
    private var withWatchProviders: String? = null

    private var withoutCompanies: String? = null
    private var withoutGenres: String? = null
    private var withoutKeywords: String? = null
    private var withoutWatchProviders: String? = null

    private var withType: String? = null

    /** Sets the inclusive lower bound for any episode air date. */
    fun airDateGte(value: LocalDate?) =
        apply {
            airDateGte = value
        }

    /** Sets the inclusive upper bound for any episode air date. */
    fun airDateLte(value: LocalDate?) =
        apply {
            airDateLte = value
        }

    /** Filters by the series' first-air-date year. */
    fun firstAirDateYear(value: Int) =
        apply {
            QueryValidation.validateYear(value, "First air date year")
            firstAirDateYear = value
        }

    /** Sets the inclusive lower bound for the series' first air date. */
    fun firstAirDateGte(value: LocalDate?) =
        apply {
            firstAirDateGte = value
        }

    /** Sets the inclusive upper bound for the series' first air date. */
    fun firstAirDateLte(value: LocalDate?) =
        apply {
            firstAirDateLte = value
        }

    /** Controls whether adult TV series may be returned. */
    fun includeAdult(value: Boolean) =
        apply {
            includeAdult = value
        }

    /** Controls whether series without a first air date may be returned. */
    fun includeNullFirstAirDates(value: Boolean) =
        apply {
            includeNullFirstAirDates = value
        }

    /** Sets the response language. */
    fun language(value: Language?) =
        apply {
            language = value
        }

    /** Sets the one-based result page. */
    override fun page(page: Int?) =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

    /** Filters by whether an episode received a theatrical screening. */
    fun screenedTheatrically(value: Boolean) =
        apply {
            screenedTheatrically = value
        }

    /** Sets the result order. */
    fun sortBy(value: TvDiscoverSortBy?) =
        apply {
            sortBy = value
        }

    /** Sets the time zone used when evaluating air dates. */
    fun timezone(value: String?) =
        apply {
            timezone = value
        }

    /** Sets the inclusive lower bound for TMDB's average user rating. */
    fun voteAverageGte(value: Double) =
        apply {
            voteAverageGte = value
        }

    /** Sets the inclusive upper bound for TMDB's average user rating. */
    fun voteAverageLte(value: Double) =
        apply {
            voteAverageLte = value
        }

    /** Sets the inclusive lower bound for the number of user ratings. */
    fun voteCountGte(value: Double) =
        apply {
            voteCountGte = value
        }

    /** Sets the inclusive upper bound for the number of user ratings. */
    fun voteCountLte(value: Double) =
        apply {
            voteCountLte = value
        }

    /** Sets the country used by watch-provider filters. */
    fun watchRegion(value: Region?) =
        apply {
            watchRegion = value
        }

    /** Filters by production-company TMDB IDs. */
    fun withCompanies(value: String?) =
        apply {
            withCompanies = value
        }

    /** Filters by genre TMDB IDs. */
    fun withGenres(value: String?) =
        apply {
            withGenres = value
        }

    /** Filters by keyword TMDB IDs. */
    fun withKeywords(value: String?) =
        apply {
            withKeywords = value
        }

    /** Filters by a network TMDB ID. */
    fun withNetworks(value: Int) =
        apply {
            withNetworks = value
        }

    /** Filters by an ISO 3166-1 country of origin. */
    fun withOriginCountry(value: String?) =
        apply {
            withOriginCountry = value
        }

    /** Filters by an ISO 639-1 original-language code. */
    fun withOriginalLanguage(value: String?) =
        apply {
            withOriginalLanguage = value
        }

    /** Sets the inclusive lower episode-runtime bound in minutes. */
    fun withRuntimeGte(value: Int) =
        apply {
            withRuntimeGte = value
        }

    /** Sets the inclusive upper episode-runtime bound in minutes. */
    fun withRuntimeLte(value: Int) =
        apply {
            withRuntimeLte = value
        }

    /** Filters by TMDB series-status values. */
    fun withStatus(value: String?) =
        apply {
            withStatus = value
        }

    /** Filters by TMDB watch-monetization types. */
    fun withWatchMonetizationTypes(value: String?) =
        apply {
            withWatchMonetizationTypes = value
        }

    /** Filters by watch-provider TMDB IDs for [watchRegion]. */
    fun withWatchProviders(value: String?) =
        apply {
            withWatchProviders = value
        }

    /** Excludes production-company TMDB IDs. */
    fun withoutCompanies(value: String?) =
        apply {
            withoutCompanies = value
        }

    /** Excludes genre TMDB IDs. */
    fun withoutGenres(value: String?) =
        apply {
            withoutGenres = value
        }

    /** Excludes keyword TMDB IDs. */
    fun withoutKeywords(value: String?) =
        apply {
            withoutKeywords = value
        }

    /** Excludes watch-provider TMDB IDs for [watchRegion]. */
    fun withoutWatchProviders(value: String?) =
        apply {
            withoutWatchProviders = value
        }

    /** Filters by TMDB series-type values. */
    fun withType(value: String?) =
        apply {
            withType = value
        }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("air_date.gte", airDateGte)
            .add("air_date.lte", airDateLte)
            .add("first_air_date_year", firstAirDateYear)
            .add("first_air_date.gte", firstAirDateGte)
            .add("first_air_date.lte", firstAirDateLte)
            .add("include_adult", includeAdult)
            .add("include_null_first_air_dates", includeNullFirstAirDates)
            .add("language", language?.value)
            .add("page", page)
            .add("screened_theatrically", screenedTheatrically)
            .add("sort_by", sortBy?.value)
            .add("timezone", timezone)
            .add("vote_average.gte", voteAverageGte)
            .add("vote_average.lte", voteAverageLte)
            .add("vote_count.gte", voteCountGte)
            .add("vote_count.lte", voteCountLte)
            .add("watch_region", watchRegion?.value)
            .add("with_companies", withCompanies)
            .add("with_genres", withGenres)
            .add("with_keywords", withKeywords)
            .add("with_networks", withNetworks)
            .add("with_origin_country", withOriginCountry)
            .add("with_original_language", withOriginalLanguage)
            .add("with_runtime.gte", withRuntimeGte)
            .add("with_runtime.lte", withRuntimeLte)
            .add("with_status", withStatus)
            .add("with_watch_monetization_types", withWatchMonetizationTypes)
            .add("with_watch_providers", withWatchProviders)
            .add("without_companies", withoutCompanies)
            .add("without_genres", withoutGenres)
            .add("without_keywords", withoutKeywords)
            .add("without_watch_providers", withoutWatchProviders)
            .add("with_type", withType)

    companion object {
        /** Creates an empty TV-discovery query. */
        @JvmStatic
        fun create(): TvDiscoverQuery = TvDiscoverQuery()
    }
}
