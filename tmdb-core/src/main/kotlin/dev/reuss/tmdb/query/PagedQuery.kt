package dev.reuss.tmdb.query

/**
 * Fluent contract for query objects that support TMDB result pages.
 *
 * @param T Concrete query type returned by [page].
 */
interface PagedQuery<T : PagedQuery<T>> : TmdbQuery {
    /**
     * Sets the one-based result page, or clears it with `null`.
     *
     * @param page One-based page number; TMDB defaults to `1` when absent.
     * @return This query instance.
     * @throws IllegalArgumentException if [page] is zero or negative
     */
    fun page(page: Int?): T
}
