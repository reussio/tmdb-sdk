package dev.reuss.tmdb.domain.discover.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB movie discover response.
 *
 * @property page current result page
 * @property results discovered movies
 * @property totalPages total available pages
 * @property totalResults total available results
 */
@JvmRecord
data class DiscoverMovieResponse(
    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<DiscoverMovie> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<DiscoverMovie>, TmdbModel