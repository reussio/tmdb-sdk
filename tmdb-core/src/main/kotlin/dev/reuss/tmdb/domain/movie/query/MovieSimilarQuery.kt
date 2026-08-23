package dev.reuss.tmdb.domain.movie.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for similar movies.
 *
 * Both language and page are optional. Page values are validated by
 * [QueryValidation.validatePage].
 */
class MovieSimilarQuery private constructor() : PagedQuery<MovieSimilarQuery> {
    private var language: Language? = null
    private var page: Int? = null

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
            .add("language", language?.value)
            .add("page", page)

    companion object {
        /** Creates an empty query that relies on TMDB defaults. */
        @JvmStatic
        fun create(): MovieSimilarQuery = MovieSimilarQuery()
    }
}
