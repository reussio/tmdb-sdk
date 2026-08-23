package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for searching TMDB TV shows.
 *
 * The search text is required and must not be blank. Optional filters are
 * first air date year, adult content inclusion, language, page and year. Page
 * and year filters are validated before serialization.
 */
class SearchTvQuery private constructor(
    override val query: String
) : SearchQuery, PagedQuery<SearchTvQuery> {

    private var firstAirDateYear: Int? = null
    private var includeAdult: Boolean? = null
    private var language: Language? = null
    private var page: Int? = null
    private var year: Int? = null

    fun firstAirDateYear(value: Int?) = apply {
        QueryValidation.validateYear(value, "First air date year")
        firstAirDateYear = value
    }

    fun includeAdult(value: Boolean?) = apply {
        includeAdult = value
    }

    fun language(value: Language?) = apply {
        language = value
    }

    override fun page(page: Int?) = apply {
        QueryValidation.validatePage(page)
        this.page = page
    }

    fun year(value: Int?) = apply {
        QueryValidation.validateYear(value, "Year")
        year = value
    }

    override fun toQueryParams(): QueryParams =
        QueryParams.create()
            .add("query", query)
            .add("first_air_date_year", firstAirDateYear)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("page", page)
            .add("year", year)

    companion object {

        @JvmStatic
        fun of(query: String): SearchTvQuery =
            SearchTvQuery(
                QueryValidation.requireNotBlank(query, "Search query")
            )
    }
}