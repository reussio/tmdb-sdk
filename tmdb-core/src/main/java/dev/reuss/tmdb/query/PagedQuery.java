package dev.reuss.tmdb.query;

/**
 * Common contract for TMDB query objects that support pagination.
 *
 * @param <T> concrete query type
 */
public interface PagedQuery<T extends PagedQuery<T>> extends TmdbQuery {

    /**
     * Sets the requested result page.
     *
     * @param page page number, starting at 1
     * @return the query instance
     */
    T page(Integer page);
}
