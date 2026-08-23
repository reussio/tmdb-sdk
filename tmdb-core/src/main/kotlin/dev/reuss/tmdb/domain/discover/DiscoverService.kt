package dev.reuss.tmdb.domain.discover

import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery

/**
 * Discovers movies and TV series through structured filters and sort criteria.
 *
 * Unlike [dev.reuss.tmdb.domain.search.SearchService], discover requests do not accept a free-text
 * title query.
 */
interface DiscoverService {
    /** Discovers movies with TMDB's default filters and sort order. */
    fun movies(): DiscoverMovieResponse

    /** Discovers movies matching [query]. */
    fun movies(query: MovieDiscoverQuery): DiscoverMovieResponse

    /** Discovers TV series with TMDB's default filters and sort order. */
    fun tv(): DiscoverTvShowResponse

    /** Discovers TV series matching [query]. */
    fun tv(query: TvDiscoverQuery): DiscoverTvShowResponse
}
