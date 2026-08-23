package dev.reuss.tmdb.domain.discover.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import java.time.LocalDate

/**
 * Builds filters for TMDB movie discovery.
 *
 * All filters are optional. TMDB ID expressions generally use a comma for logical AND and a pipe
 * for logical OR. Supplying [region] changes which release date is selected for each movie; if
 * [withReleaseType] is also set, the order of its release-type values determines precedence.
 * Watch-provider filters should be paired with [watchRegion].
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

    /** Filters to one certification in [certificationCountry]. */
    fun certification(value: String?) =
        apply {
            certification = value
        }

    /** Sets the inclusive lower certification bound in [certificationCountry]. */
    fun certificationGte(value: String?) =
        apply {
            certificationGte = value
        }

    /** Sets the inclusive upper certification bound in [certificationCountry]. */
    fun certificationLte(value: String?) =
        apply {
            certificationLte = value
        }

    /** Sets the ISO 3166-1 country whose certification system is used. */
    fun certificationCountry(value: String?) =
        apply {
            certificationCountry = value
        }

    /** Controls whether adult movies may be returned. */
    fun includeAdult(value: Boolean) =
        apply {
            includeAdult = value
        }

    /** Controls whether movies with video content may be returned. */
    fun includeVideo(value: Boolean) =
        apply {
            includeVideo = value
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

    /** Filters by primary release year. */
    fun primaryReleaseYear(value: Int) =
        apply {
            QueryValidation.validateYear(value, "Primary release year")
            primaryReleaseYear = value
        }

    /** Sets the inclusive lower bound for the primary release date. */
    fun primaryReleaseDateGte(value: LocalDate?) =
        apply {
            primaryReleaseDateGte = value
        }

    /** Sets the inclusive upper bound for the primary release date. */
    fun primaryReleaseDateLte(value: LocalDate?) =
        apply {
            primaryReleaseDateLte = value
        }

    /** Selects the ISO 3166-1 region used to choose a release date. */
    fun region(value: Region?) =
        apply {
            region = value
        }

    /** Sets the inclusive lower bound for any matching release date. */
    fun releaseDateGte(value: LocalDate?) =
        apply {
            releaseDateGte = value
        }

    /** Sets the inclusive upper bound for any matching release date. */
    fun releaseDateLte(value: LocalDate?) =
        apply {
            releaseDateLte = value
        }

    /** Sets the result order. */
    fun sortBy(value: MovieDiscoverSortBy?) =
        apply {
            sortBy = value
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

    /** Filters by cast-person TMDB IDs. */
    fun withCast(value: String?) =
        apply {
            withCast = value
        }

    /** Filters by production-company TMDB IDs. */
    fun withCompanies(value: String?) =
        apply {
            withCompanies = value
        }

    /** Filters by crew-person TMDB IDs. */
    fun withCrew(value: String?) =
        apply {
            withCrew = value
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

    /** Filters by cast or crew person TMDB IDs. */
    fun withPeople(value: String?) =
        apply {
            withPeople = value
        }

    /**
     * Filters by release types, where 1–6 represent premiere through TV release.
     *
     * The value order controls which matching release date TMDB uses with [region].
     */
    fun withReleaseType(value: String?) =
        apply {
            withReleaseType = value
        }

    /** Sets the inclusive lower runtime bound in minutes. */
    fun withRuntimeGte(value: Int) =
        apply {
            withRuntimeGte = value
        }

    /** Sets the inclusive upper runtime bound in minutes. */
    fun withRuntimeLte(value: Int) =
        apply {
            withRuntimeLte = value
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

    /** Filters by any release date occurring in the given year. */
    fun year(value: Int) =
        apply {
            QueryValidation.validateYear(value, "Year")
            year = value
        }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
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
        /** Creates an empty movie-discovery query. */
        @JvmStatic
        fun create(): MovieDiscoverQuery = MovieDiscoverQuery()
    }
}
