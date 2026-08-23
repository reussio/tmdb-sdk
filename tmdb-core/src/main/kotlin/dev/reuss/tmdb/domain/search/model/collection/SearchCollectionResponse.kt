package dev.reuss.tmdb.domain.search.model.collection

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB collection search response.
 *
 * @property page current result page
 * @property results found collections
 * @property totalPages total available pages
 * @property totalResults total available results
 */
@JvmRecord
data class SearchCollectionResponse(
    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<SearchCollection> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<SearchCollection>, TmdbModel