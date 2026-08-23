package dev.reuss.tmdb.domain.trending.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB trending TV series response.
 *
 * @property page One-based index of this result page.
 * @property results trending TV series
 * @property totalPages Total number of result pages reported by TMDB.
 * @property totalResults Total number of matching results reported by TMDB.
 */
@JvmRecord
data class TrendingTvShowResponse(
    @all:JsonProperty("page")
    override val page: Int,
    @all:JsonProperty("results")
    override val results: List<TrendingTvShow> = emptyList(),
    @all:JsonProperty("total_pages")
    override val totalPages: Int,
    @all:JsonProperty("total_results")
    override val totalResults: Int,
) : PagedResponse<TrendingTvShow>,
    TmdbModel
