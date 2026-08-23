package dev.reuss.tmdb.domain.discover

import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery

/**
 * Service for discovering TMDB media using filters and sort options.
 */
interface DiscoverService {
    fun movies(): DiscoverMovieResponse

    fun movies(query: MovieDiscoverQuery): DiscoverMovieResponse

    fun tv(): DiscoverTvShowResponse

    fun tv(query: TvDiscoverQuery): DiscoverTvShowResponse
}
