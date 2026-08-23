package dev.reuss.tmdb.domain.discover

import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery

/**
 * Default [DiscoverService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultDiscoverService(
    private val httpClient: TmdbHttpClient,
) : DiscoverService {
    override fun movies(): DiscoverMovieResponse = movies(MovieDiscoverQuery.create())

    override fun movies(query: MovieDiscoverQuery): DiscoverMovieResponse =
        httpClient.get(
            TmdbRequest.get(
                DiscoverPaths.movies(),
                query.toQueryParams(),
            ),
            DiscoverMovieResponse::class.java,
        )

    override fun tv(): DiscoverTvShowResponse = tv(TvDiscoverQuery.create())

    override fun tv(query: TvDiscoverQuery): DiscoverTvShowResponse =
        httpClient.get(
            TmdbRequest.get(
                DiscoverPaths.tvSeries(),
                query.toQueryParams(),
            ),
            DiscoverTvShowResponse::class.java,
        )
}
