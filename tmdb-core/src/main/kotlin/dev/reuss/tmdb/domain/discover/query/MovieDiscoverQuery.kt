package dev.reuss.tmdb.domain.discover.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.time.LocalDate

/**
 * Query parameters for TMDB movie discovery.
 *
 * All fields are optional. Page and year filters are validated before
 * serialization; other filters are passed through using TMDB's discover movie
 * query parameter names.
 */
class MovieDiscoverQuery private constructor() : PagedQuery<MovieDiscoverQuery> {

    private var certification: String? = null
    private var certificationGte: String? = null
    private var certificationLte: String? = null
    private var certificationCountry: String? = null

    private var includeAdult: Boolean? = null
    private var includeVideo: Boolean? = null

    private var language: Language? = null
    private var page: Int? = null

    private var primaryReleaseYear: Int? = null
    private var primaryReleaseDateGte: LocalDate? = null
    private var primaryReleaseDateLte: LocalDate? = null

    private var region: Region? = null

    private var releaseDateGte: LocalDate? = null
    private var releaseDateLte: LocalDate? = null

    private var sortBy: MovieDiscoverSortBy? = null

    private var voteAverageGte: Double? = null
    private var voteAverageLte: Double? = null
    private var voteCountGte: Double? = null
    private var voteCountLte: Double? = null

    private var watchRegion: Region? = null

    private var withCast: String? = null
    private var withCompanies: String? = null
    private var withCrew: String? = null
    private var withGenres: String? = null
    private var withKeywords: String? = null
    private var withOriginCountry: String? = null
    private var withOriginalLanguage: String? = null
    private var withPeople: String? = null
    private var withReleaseType: String? = null

    private var withRuntimeGte: Int? = null
    private var withRuntimeLte: Int? = null

    private var withWatchMonetizationTypes: String? = null
    private var withWatchProviders: String? = null

    private var withoutCompanies: String? = null
    private var withoutGenres: String? = null
    private var withoutKeywords: String? = null
    private var withoutWatchProviders: String? = null

    private var year: Int? = null

    fun certification(value: String?) = apply {
        certification = value
    }

    fun certificationGte(value: String?) = apply {
        certificationGte = value
    }

    fun certificationLte(value: String?) = apply {
        certificationLte = value
    }

    fun certificationCountry(value: String?) = apply {
        certificationCountry = value
    }

    fun includeAdult(value: Boolean) = apply {
        includeAdult = value
    }

    fun includeVideo(value: Boolean) = apply {
        includeVideo = value
    }

    fun language(value: Language?) = apply {
        language = value
    }

    override fun page(page: Int?) = apply {
        QueryValidation.validatePage(page)
        this.page = page
    }

    fun primaryReleaseYear(value: Int) = apply {
        QueryValidation.validateYear(value, "Primary release year")
        primaryReleaseYear = value
    }

    fun primaryReleaseDateGte(value: LocalDate?) = apply {
        primaryReleaseDateGte = value
    }

    fun primaryReleaseDateLte(value: LocalDate?) = apply {
        primaryReleaseDateLte = value
    }

    fun region(value: Region?) = apply {
        region = value
    }

    fun releaseDateGte(value: LocalDate?) = apply {
        releaseDateGte = value
    }

    fun releaseDateLte(value: LocalDate?) = apply {
        releaseDateLte = value
    }

    fun sortBy(value: MovieDiscoverSortBy?) = apply {
        sortBy = value
    }

    fun voteAverageGte(value: Double) = apply {
        voteAverageGte = value
    }

    fun voteAverageLte(value: Double) = apply {
        voteAverageLte = value
    }

    fun voteCountGte(value: Double) = apply {
        voteCountGte = value
    }

    fun voteCountLte(value: Double) = apply {
        voteCountLte = value
    }

    fun watchRegion(value: Region?) = apply {
        watchRegion = value
    }

    fun withCast(value: String?) = apply {
        withCast = value
    }

    fun withCompanies(value: String?) = apply {
        withCompanies = value
    }

    fun withCrew(value: String?) = apply {
        withCrew = value
    }

    fun withGenres(value: String?) = apply {
        withGenres = value
    }

    fun withKeywords(value: String?) = apply {
        withKeywords = value
    }

    fun withOriginCountry(value: String?) = apply {
        withOriginCountry = value
    }

    fun withOriginalLanguage(value: String?) = apply {
        withOriginalLanguage = value
    }

    fun withPeople(value: String?) = apply {
        withPeople = value
    }

    fun withReleaseType(value: String?) = apply {
        withReleaseType = value
    }

    fun withRuntimeGte(value: Int) = apply {
        withRuntimeGte = value
    }

    fun withRuntimeLte(value: Int) = apply {
        withRuntimeLte = value
    }

    fun withWatchMonetizationTypes(value: String?) = apply {
        withWatchMonetizationTypes = value
    }

    fun withWatchProviders(value: String?) = apply {
        withWatchProviders = value
    }

    fun withoutCompanies(value: String?) = apply {
        withoutCompanies = value
    }

    fun withoutGenres(value: String?) = apply {
        withoutGenres = value
    }

    fun withoutKeywords(value: String?) = apply {
        withoutKeywords = value
    }

    fun withoutWatchProviders(value: String?) = apply {
        withoutWatchProviders = value
    }

    fun year(value: Int) = apply {
        QueryValidation.validateYear(value, "Year")
        year = value
    }

    override fun toQueryParams(): QueryParams =
        QueryParams.create()
            .add("certification", certification)
            .add("certification.gte", certificationGte)
            .add("certification.lte", certificationLte)
            .add("certification_country", certificationCountry)
            .add("include_adult", includeAdult)
            .add("include_video", includeVideo)
            .add("language", language?.value)
            .add("page", page)
            .add("primary_release_year", primaryReleaseYear)
            .add("primary_release_date.gte", primaryReleaseDateGte)
            .add("primary_release_date.lte", primaryReleaseDateLte)
            .add("region", region?.value)
            .add("release_date.gte", releaseDateGte)
            .add("release_date.lte", releaseDateLte)
            .add("sort_by", sortBy?.value)
            .add("vote_average.gte", voteAverageGte)
            .add("vote_average.lte", voteAverageLte)
            .add("vote_count.gte", voteCountGte)
            .add("vote_count.lte", voteCountLte)
            .add("watch_region", watchRegion?.value)
            .add("with_cast", withCast)
            .add("with_companies", withCompanies)
            .add("with_crew", withCrew)
            .add("with_genres", withGenres)
            .add("with_keywords", withKeywords)
            .add("with_origin_country", withOriginCountry)
            .add("with_original_language", withOriginalLanguage)
            .add("with_people", withPeople)
            .add("with_release_type", withReleaseType)
            .add("with_runtime.gte", withRuntimeGte)
            .add("with_runtime.lte", withRuntimeLte)
            .add("with_watch_monetization_types", withWatchMonetizationTypes)
            .add("with_watch_providers", withWatchProviders)
            .add("without_companies", withoutCompanies)
            .add("without_genres", withoutGenres)
            .add("without_keywords", withoutKeywords)
            .add("without_watch_providers", withoutWatchProviders)
            .add("year", year)

    companion object {

        @JvmStatic
        fun create(): MovieDiscoverQuery =
            MovieDiscoverQuery()
    }
}