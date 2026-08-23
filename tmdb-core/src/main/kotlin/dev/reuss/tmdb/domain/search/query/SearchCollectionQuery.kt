package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Query parameters for searching TMDB collections.
 *
 * The search text is required and must not be blank. Optional filters are
 * adult content inclusion, language, page and region. Page values are validated
 * by [QueryValidation.validatePage].
 */
class SearchCollectionQuery private constructor(
    override val query: String,
) : SearchQuery,
    PagedQuery<SearchCollectionQuery> {
    private var includeAdult: Boolean? = null
    private var language: Language? = null
    private var page: Int? = null
    private var region: Region? = null

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

    /** Sets the ISO 3166-1 region used to localize release information. */
    fun region(value: Region?) =
        apply {
            region = value
        }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("query", query)
            .add("include_adult", includeAdult)
            .add("language", language?.value)
            .add("page", page)
            .add("region", region?.value)

    companion object {
        /**
         * Creates a query for trimmed [query] text.
         *
         * @throws IllegalArgumentException if [query] is blank
         */
        @JvmStatic
        fun of(query: String): SearchCollectionQuery =
            SearchCollectionQuery(
                QueryValidation.requireNotBlank(query, "Search query"),
            )
    }
}
