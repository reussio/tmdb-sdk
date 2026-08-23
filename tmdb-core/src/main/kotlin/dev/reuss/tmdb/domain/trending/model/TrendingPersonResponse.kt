package dev.reuss.tmdb.domain.trending.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB trending people response.
 *
 * @property page current result page
 * @property results trending people
 * @property totalPages total available pages
 * @property totalResults total available results
 */
@JvmRecord
data class TrendingPersonResponse(
    @all:JsonProperty("page")
    override val page: Int,
    @all:JsonProperty("results")
    override val results: List<TrendingPerson> = emptyList(),
    @all:JsonProperty("total_pages")
    override val totalPages: Int,
    @all:JsonProperty("total_results")
    override val totalResults: Int,
) : PagedResponse<TrendingPerson>,
    TmdbModel
