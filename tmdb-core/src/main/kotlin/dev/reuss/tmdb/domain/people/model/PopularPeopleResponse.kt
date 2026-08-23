package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.page.PagedResponse

/**
 * Paged response for popular people.
 *
 * @property page current page
 * @property results popular people
 * @property totalPages total pages
 * @property totalResults total results
 */
@JvmRecord
data class PopularPeopleResponse(
    @all:JsonProperty("page")
    override val page: Int,

    @all:JsonProperty("results")
    override val results: List<PopularPerson> = emptyList(),

    @all:JsonProperty("total_pages")
    override val totalPages: Int,

    @all:JsonProperty("total_results")
    override val totalResults: Int
) : PagedResponse<PopularPerson>, TmdbModel