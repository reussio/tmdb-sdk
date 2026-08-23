package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for searching movies, TV shows and people.
 *
 * The search text is required and must not be blank. Optional filters are
 * adult content inclusion, language and page. Page values are validated by
 * [QueryValidation.validatePage].
 */
class SearchMultiQuery private constructor(
    override val query: String,
) : SearchQuery,
    PagedQuery<SearchMultiQuery> {
    private var includeAdult: Boolean? = null
    private var language: Language? = null
    private var page: Int? = null

    fun includeAdult(value: Boolean?) =
        apply {
            includeAdult = value
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

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("query", query)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("page", page)

    companion object {
        @JvmStatic
        fun of(query: String): SearchMultiQuery =
            SearchMultiQuery(
                QueryValidation.requireNotBlank(query, "Search query"),
            )
    }
}
