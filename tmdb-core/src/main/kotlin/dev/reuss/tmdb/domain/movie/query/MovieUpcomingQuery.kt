package dev.reuss.tmdb.domain.movie.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Query parameters for TMDB upcoming movie lists.
 *
 * Language, page and region are optional. Page values are validated by
 * [QueryValidation.validatePage].
 */
class MovieUpcomingQuery private constructor() : PagedQuery<MovieUpcomingQuery> {
    private var language: Language? = null
    private var page: Int? = null
    private var region: Region? = null

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
            .add("language", language?.value)
            .add("page", page)
            .add("region", region?.value)

    companion object {
        /** Creates an empty query that relies on TMDB defaults. */
        @JvmStatic
        fun create(): MovieUpcomingQuery = MovieUpcomingQuery()
    }
}
