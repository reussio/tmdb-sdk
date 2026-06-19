package dev.reuss.tmdb.domain.discover;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse;
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse;
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery;
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery;

import java.util.Objects;

/**
 * Default {@link DiscoverService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultDiscoverService implements DiscoverService {

    private final TmdbHttpClient httpClient;

    public DefaultDiscoverService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public DiscoverMovieResponse movies() {
        return movies(MovieDiscoverQuery.create());
    }

    @Override
    public DiscoverMovieResponse movies(MovieDiscoverQuery query) {
        Objects.requireNonNull(query, "Movie discover query must not be null");

        return httpClient.get(
                TmdbRequest.get(DiscoverPaths.movies(), query.toQueryParams()),
                DiscoverMovieResponse.class
        );
    }

    @Override
    public DiscoverTvShowResponse tv() {
        return tv(TvDiscoverQuery.create());
    }

    @Override
    public DiscoverTvShowResponse tv(TvDiscoverQuery query) {
        Objects.requireNonNull(query, "TV discover query must not be null");

        return httpClient.get(
                TmdbRequest.get(DiscoverPaths.tvSeries(), query.toQueryParams()),
                DiscoverTvShowResponse.class
        );
    }
}