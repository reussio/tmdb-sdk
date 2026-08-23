package dev.reuss.tmdb.domain.discover.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.time.LocalDate

/**
 * Query parameters for TMDB TV discovery.
 *
 * All fields are optional. Page and year filters are validated before
 * serialization; other filters are passed through using TMDB's discover TV
 * query parameter names.
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

    fun airDateGte(value: LocalDate?) =
        apply {
            airDateGte = value
        }

    fun airDateLte(value: LocalDate?) =
        apply {
            airDateLte = value
        }

    fun firstAirDateYear(value: Int) =
        apply {
            QueryValidation.validateYear(value, "First air date year")
            firstAirDateYear = value
        }

    fun firstAirDateGte(value: LocalDate?) =
        apply {
            firstAirDateGte = value
        }

    fun firstAirDateLte(value: LocalDate?) =
        apply {
            firstAirDateLte = value
        }

    fun includeAdult(value: Boolean) =
        apply {
            includeAdult = value
        }

    fun includeNullFirstAirDates(value: Boolean) =
        apply {
            includeNullFirstAirDates = value
        }

    fun language(value: Language?) =
        apply {
            language = value
        }

    override fun page(page: Int?) =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

    fun screenedTheatrically(value: Boolean) =
        apply {
            screenedTheatrically = value
        }

    fun sortBy(value: TvDiscoverSortBy?) =
        apply {
            sortBy = value
        }

    fun timezone(value: String?) =
        apply {
            timezone = value
        }

    fun voteAverageGte(value: Double) =
        apply {
            voteAverageGte = value
        }

    fun voteAverageLte(value: Double) =
        apply {
            voteAverageLte = value
        }

    fun voteCountGte(value: Double) =
        apply {
            voteCountGte = value
        }

    fun voteCountLte(value: Double) =
        apply {
            voteCountLte = value
        }

    fun watchRegion(value: Region?) =
        apply {
            watchRegion = value
        }

    fun withCompanies(value: String?) =
        apply {
            withCompanies = value
        }

    fun withGenres(value: String?) =
        apply {
            withGenres = value
        }

    fun withKeywords(value: String?) =
        apply {
            withKeywords = value
        }

    fun withNetworks(value: Int) =
        apply {
            withNetworks = value
        }

    fun withOriginCountry(value: String?) =
        apply {
            withOriginCountry = value
        }

    fun withOriginalLanguage(value: String?) =
        apply {
            withOriginalLanguage = value
        }

    fun withRuntimeGte(value: Int) =
        apply {
            withRuntimeGte = value
        }

    fun withRuntimeLte(value: Int) =
        apply {
            withRuntimeLte = value
        }

    fun withStatus(value: String?) =
        apply {
            withStatus = value
        }

    fun withWatchMonetizationTypes(value: String?) =
        apply {
            withWatchMonetizationTypes = value
        }

    fun withWatchProviders(value: String?) =
        apply {
            withWatchProviders = value
        }

    fun withoutCompanies(value: String?) =
        apply {
            withoutCompanies = value
        }

    fun withoutGenres(value: String?) =
        apply {
            withoutGenres = value
        }

    fun withoutKeywords(value: String?) =
        apply {
            withoutKeywords = value
        }

    fun withoutWatchProviders(value: String?) =
        apply {
            withoutWatchProviders = value
        }

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
        @JvmStatic
        fun create(): TvDiscoverQuery = TvDiscoverQuery()
    }
}
