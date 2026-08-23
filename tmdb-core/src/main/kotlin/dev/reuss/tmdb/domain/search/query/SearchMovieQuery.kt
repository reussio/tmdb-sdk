package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Query parameters for searching TMDB movies.
 *
 * The search text is required and must not be blank. Optional filters are
 * adult content inclusion, language, page, region, year and primary release
 * year. Page and year filters are validated before serialization.
 */
class SearchMovieQuery private constructor(
    override val query: String,
) : SearchQuery,
    PagedQuery<SearchMovieQuery> {
    private var includeAdult: Boolean? = null
    private var language: Language? = null
    private var primaryReleaseYear: Int? = null
    private var page: Int? = null
    private var region: Region? = null
    private var year: Int? = null

    /** Controls whether adult results may be returned; `null` uses the TMDB default. */
    fun includeAdult(value: Boolean?) =
        apply {
            includeAdult = value
        }

    /** Sets the response language; `null` leaves the parameter unspecified. */
    fun language(value: Language?) =
        apply {
            language = value
        }

    /** Filters movies by their primary release year. */
    fun primaryReleaseYear(value: Int) =
        apply {
            QueryValidation.validateYear(value, "Primary release year")
            primaryReleaseYear = value
        }

    /** Sets the one-based result page; `null` leaves the parameter unspecified. */
    override fun page(page: Int?) =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

    /** Sets the ISO 3166-1 region used to localize release information. */
    fun region(value: Region?) =
        apply {
            region = value
        }

    /** Filters by any movie release date occurring in the given year. */
    fun year(value: Int) =
        apply {
            QueryValidation.validateYear(value, "Year")
            year = value
        }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("query", query)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("primary_release_year", primaryReleaseYear)
            .add("page", page)
            .add("region", region?.value)
            .add("year", year)

    companion object {
        /**
         * Creates a query for trimmed [query] text.
         *
         * @throws IllegalArgumentException if [query] is blank
         */
        @JvmStatic
        fun of(query: String): SearchMovieQuery =
            SearchMovieQuery(
                QueryValidation.requireNotBlank(query, "Search query"),
            )
    }
}
