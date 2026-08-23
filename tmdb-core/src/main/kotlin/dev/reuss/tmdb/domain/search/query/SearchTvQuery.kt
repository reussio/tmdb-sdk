package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for searching TMDB TV series.
 *
 * The search text is required and must not be blank. Optional filters are
 * first air date year, adult content inclusion, language, page and year. Page
 * and year filters are validated before serialization.
 */
class SearchTvQuery private constructor(
    override val query: String,
) : SearchQuery,
    PagedQuery<SearchTvQuery> {
    private var firstAirDateYear: Int? = null
    private var includeAdult: Boolean? = null
    private var language: Language? = null
    private var page: Int? = null
    private var year: Int? = null

    /** Filters TV series by the year of their first air date. */
    fun firstAirDateYear(value: Int?) =
        apply {
            QueryValidation.validateYear(value, "First air date year")
            firstAirDateYear = value
        }

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

    /** Sets the one-based result page; `null` leaves the parameter unspecified. */
    override fun page(page: Int?) =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

    /** Filters by the first air date year or an episode air date year. */
    fun year(value: Int?) =
        apply {
            QueryValidation.validateYear(value, "Year")
            year = value
        }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("query", query)
            .add("first_air_date_year", firstAirDateYear)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("page", page)
            .add("year", year)

    companion object {
        /**
         * Creates a query for trimmed [query] text.
         *
         * @throws IllegalArgumentException if [query] is blank
         */
        @JvmStatic
        fun of(query: String): SearchTvQuery =
            SearchTvQuery(
                QueryValidation.requireNotBlank(query, "Search query"),
            )
    }
}
