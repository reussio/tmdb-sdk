package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Recommended TV series for a TMDB TV series.
 *
 * @property page One-based index of this result page.
 * @property results recommended TV series
 * @property totalPages Total number of result pages reported by TMDB.
 * @property totalResults Total number of matching results reported by TMDB.
 */
@JvmRecord
data class TvSeriesRecommendations(
    @all:JsonProperty("page")
    override val page: Int,
    @all:JsonProperty("results")
    override val results: List<TvSeriesRecommendation> = emptyList(),
    @all:JsonProperty("total_pages")
    override val totalPages: Int,
    @all:JsonProperty("total_results")
    override val totalResults: Int,
) : PagedResponse<TvSeriesRecommendation>,
    TmdbModel
