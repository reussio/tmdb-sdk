package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Similar TV series for a TMDB TV series.
 *
 * @property page current page
 * @property results similar TV series
 * @property totalPages total pages
 * @property totalResults total results
 */
@JvmRecord
data class TvSeriesSimilar(
    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<TvSeriesSimilarItem> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<TvSeriesSimilarItem>, TmdbModel