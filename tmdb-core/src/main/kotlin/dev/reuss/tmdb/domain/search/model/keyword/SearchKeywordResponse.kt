package dev.reuss.tmdb.domain.search.model.keyword

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB keyword search response.
 *
 * @property page One-based index of this result page.
 * @property results found keywords
 * @property totalPages Total number of result pages reported by TMDB.
 * @property totalResults Total number of matching results reported by TMDB.
 */
@JvmRecord
data class SearchKeywordResponse(
    @all:JsonProperty("page")
    override val page: Int,
    @all:JsonProperty("results")
    override val results: List<Keyword> = emptyList(),
    @all:JsonProperty("total_pages")
    override val totalPages: Int,
    @all:JsonProperty("total_results")
    override val totalResults: Int,
) : PagedResponse<Keyword>,
    TmdbModel
