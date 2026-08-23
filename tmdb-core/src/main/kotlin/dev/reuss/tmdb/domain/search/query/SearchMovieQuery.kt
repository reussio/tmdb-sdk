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
    override val query: String
) : SearchQuery, PagedQuery<SearchMovieQuery> {

    private var includeAdult: Boolean? = null
    private var language: Language? = null
    private var primaryReleaseYear: Int? = null
    private var page: Int? = null
    private var region: Region? = null
    private var year: Int? = null

    fun includeAdult(value: Boolean?) = apply {
        includeAdult = value
    }

    fun language(value: Language?) = apply {
        language = value
    }

    fun primaryReleaseYear(value: Int) = apply {
        QueryValidation.validateYear(value, "Primary release year")
        primaryReleaseYear = value
    }

    override fun page(page: Int?) = apply {
        QueryValidation.validatePage(page)
        this.page = page
    }

    fun region(value: Region?) = apply {
        region = value
    }

    fun year(value: Int) = apply {
        QueryValidation.validateYear(value, "Year")
        year = value
    }

    override fun toQueryParams(): QueryParams =
        QueryParams.create()
            .add("query", query)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("primary_release_year", primaryReleaseYear)
            .add("page", page)
            .add("region", region?.value)
            .add("year", year)

    companion object {

        @JvmStatic
        fun of(query: String): SearchMovieQuery =
            SearchMovieQuery(
                QueryValidation.requireNotBlank(query, "Search query")
            )
    }
}