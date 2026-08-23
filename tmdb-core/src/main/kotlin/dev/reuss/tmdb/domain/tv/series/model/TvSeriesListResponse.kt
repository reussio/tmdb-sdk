package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB TV series list response.
 *
 * @property page current page
 * @property results TV series results
 * @property totalPages total pages
 * @property totalResults total results
 */
@JvmRecord
data class TvSeriesListResponse(
    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<TvSeriesListItem> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<TvSeriesListItem>, TmdbModel