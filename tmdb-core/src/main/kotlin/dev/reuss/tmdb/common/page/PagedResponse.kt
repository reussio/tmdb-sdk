package dev.reuss.tmdb.common.page

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.OptionalInt

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

    fun hasNextPage(): Boolean = page < totalPages

    fun hasPreviousPage(): Boolean = page > 1

    fun isFirstPage(): Boolean = page <= 1

    fun isLastPage(): Boolean = page >= totalPages

    fun isEmpty(): Boolean = resultCount() == 0

    fun hasResults(): Boolean = !isEmpty()

    fun resultCount(): Int = results.size

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

    fun nextPageNumber(): OptionalInt = if (hasNextPage()) OptionalInt.of(page + 1) else OptionalInt.empty()

    fun previousPageNumber(): OptionalInt = if (hasPreviousPage()) OptionalInt.of(page - 1) else OptionalInt.empty()
}
