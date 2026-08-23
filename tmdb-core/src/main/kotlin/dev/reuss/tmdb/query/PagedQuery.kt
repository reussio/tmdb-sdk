package dev.reuss.tmdb.query

/**
 * Common contract for TMDB query objects that support pagination.
 *
 * @property T concrete query type
 */
interface PagedQuery<T : PagedQuery<T>> : TmdbQuery {
    /**
     * Sets the requested result page.
     *
     * @property page page number, starting at 1
     * @return the query instance
     */
    fun page(page: Int?): T
}
