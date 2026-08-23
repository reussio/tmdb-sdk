package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.query.TmdbQuery

/**
 * Common contract for TMDB search query objects.
 */
interface SearchQuery : TmdbQuery {
    val query: String
}
