package dev.reuss.tmdb.domain.tv.series.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.PagedQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for date-based TMDB TV series list endpoints.
 *
 * Language, page and timezone are optional. Page values are validated by
 * [QueryValidation.validatePage].
 */
class TvSeriesDateListQuery private constructor() : PagedQuery<TvSeriesDateListQuery> {

    private var language: Language? = null
    private var page: Int? = null
    private var timezone: String? = null

    fun language(value: Language?) = apply {
        language = value
    }

    override fun page(page: Int?) = apply {
        QueryValidation.validatePage(page)
        this.page = page
    }

    /**
     * Sets the timezone used by date-based TV list endpoints.
     *
     * @param value timezone, for example `Europe/Berlin`
     * @return this query
     */
    fun timezone(value: String?) = apply {
        timezone = value
    }

    override fun toQueryParams(): QueryParams =
        QueryParams.create()
            .add("language", language?.value)
            .add("page", page)
            .add("timezone", timezone)

    companion object {

        @JvmStatic
        fun create(): TvSeriesDateListQuery =
            TvSeriesDateListQuery()
    }
}