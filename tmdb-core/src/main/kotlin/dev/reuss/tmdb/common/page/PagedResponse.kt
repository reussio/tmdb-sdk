package dev.reuss.tmdb.common.page

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

/**
 * Common contract for paginated TMDB responses.
 *
 * @property <T> result item type
 */

interface PagedResponse<T> {

    val page: Int

    val results: List<T>

    @get:JsonProperty("total_pages")
    val totalPages: Int

    @get:JsonProperty("total_results")
    val totalResults: Int

    fun hasNextPage(): Boolean {
        return page < totalPages
    }

    fun hasPreviousPage(): Boolean {
        return page > 1
    }

    fun isFirstPage(): Boolean {
        return page <= 1
    }

    fun isLastPage(): Boolean {
        return page >= totalPages
    }

    fun isEmpty(): Boolean {
        return resultCount() == 0
    }

    fun hasResults(): Boolean {
        return !isEmpty()
    }

    fun resultCount(): Int {
        return results.size
    }

    fun nextPage(): Int {
        if (!hasNextPage()) {
            throw IllegalStateException("There is no next page")
        }

        return page + 1
    }

    fun previousPage(): Int {
        if (!hasPreviousPage()) {
            throw IllegalStateException("There is no previous page")
        }

        return page - 1
    }

    fun nextPageNumber(): OptionalInt {
        return if (hasNextPage()) OptionalInt.of(page + 1) else OptionalInt.empty()
    }

    fun previousPageNumber(): OptionalInt {
        return if (hasPreviousPage()) OptionalInt.of(page - 1) else OptionalInt.empty()
    }
}
