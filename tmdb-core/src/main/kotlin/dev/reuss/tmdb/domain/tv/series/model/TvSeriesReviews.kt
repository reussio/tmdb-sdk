package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse
import dev.reuss.tmdb.common.review.Review

/**
 * Reviews for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property page current page
 * @property results TV series reviews
 * @property totalPages total pages
 * @property totalResults total results
 */
@JvmRecord
data class TvSeriesReviews(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("page")
    override val page: Int,
    @all:JsonProperty("results")
    override val results: List<Review> = emptyList(),
    @all:JsonProperty("total_pages")
    override val totalPages: Int,
    @all:JsonProperty("total_results")
    override val totalResults: Int,
) : PagedResponse<Review>,
    TmdbModel
