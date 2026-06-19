package dev.reuss.tmdb.domain.search;

import dev.reuss.tmdb.query.TmdbQuery;

/**
 * Common contract for TMDB search query objects.
 */
public interface SearchQuery extends TmdbQuery {

    String query();
}