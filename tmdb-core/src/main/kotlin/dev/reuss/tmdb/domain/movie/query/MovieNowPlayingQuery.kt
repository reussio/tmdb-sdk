package dev.reuss.tmdb.domain.movie.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Query parameters for TMDB now playing movie lists.
 *
 * Language, page and region are optional. Page values are validated by
 * [QueryValidation.validatePage].
 */
class MovieNowPlayingQuery private constructor() : PagedQuery<MovieNowPlayingQuery> {
    private var language: Language? = null
    private var page: Int? = null
    private var region: Region? = null

    fun language(value: Language?) =
        apply {
            language = value
        }

    override fun page(page: Int?) =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

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
        @JvmStatic
        fun create(): MovieNowPlayingQuery = MovieNowPlayingQuery()
    }
}
