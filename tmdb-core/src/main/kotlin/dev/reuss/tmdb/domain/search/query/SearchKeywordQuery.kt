package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation

/**
 * Query parameters for searching TMDB keywords.
 *
 * The search text is required and must not be blank. The optional page value
 * is validated by [QueryValidation.validatePage].
 */
class SearchKeywordQuery private constructor(
    override val query: String
) : SearchQuery, PagedQuery<SearchKeywordQuery> {

    private var page: Int? = null

    override fun page(page: Int?) = apply {
        QueryValidation.validatePage(page)
        this.page = page
    }

    override fun toQueryParams(): QueryParams =
        QueryParams.create()
            .add("query", query)
            .add("page", page)

    companion object {

        @JvmStatic
        fun of(query: String): SearchKeywordQuery =
            SearchKeywordQuery(
                QueryValidation.requireNotBlank(query, "Search query")
            )
    }
}