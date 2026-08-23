package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paginated TMDB now playing movie response.
 *
 * @property dates result date range
 * @property page current page
 * @property results movie results
 * @property totalPages total pages
 * @property totalResults total results
 */
@JvmRecord
data class MovieNowPlayingResponse(
    @all:JsonProperty("dates")
    val dates: MovieNowPlayingDates?,

    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<MovieListItem> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<MovieListItem>, TmdbModel