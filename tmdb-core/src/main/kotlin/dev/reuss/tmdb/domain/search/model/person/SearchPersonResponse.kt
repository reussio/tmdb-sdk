package dev.reuss.tmdb.domain.search.model.person

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB person search response.
 *
 * @property page current result page
 * @property results found people
 * @property totalPages total available pages
 * @property totalResults total available results
 */
@JvmRecord
data class SearchPersonResponse(
    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<SearchPerson> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<SearchPerson>, TmdbModel