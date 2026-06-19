package dev.reuss.tmdb.domain.discover;

import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse;
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse;
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery;
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery;

/**
 * Service for discovering TMDB media using filters and sort options.
 */
public interface DiscoverService {

    DiscoverMovieResponse movies();

    DiscoverMovieResponse movies(MovieDiscoverQuery query);

    DiscoverTvShowResponse tv();

    DiscoverTvShowResponse tv(TvDiscoverQuery query);
}