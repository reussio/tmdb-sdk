package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for searching movies, TV series, and people in one request.
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

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("query", query)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("page", page)

    companion object {
        /**
         * Creates a query for trimmed [query] text.
         *
         * @throws IllegalArgumentException if [query] is blank
         */
        @JvmStatic
        fun of(query: String): SearchMultiQuery =
            SearchMultiQuery(
                QueryValidation.requireNotBlank(query, "Search query"),
            )
    }
}
