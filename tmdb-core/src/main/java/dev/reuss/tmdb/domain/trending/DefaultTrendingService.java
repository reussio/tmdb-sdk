package dev.reuss.tmdb.domain.trending;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.trending.model.*;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default {@link TrendingService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultTrendingService implements TrendingService {

    private final TmdbHttpClient httpClient;

    public DefaultTrendingService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public TrendingAllResponse all(TrendingTimeWindow timeWindow) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");

        return httpClient.get(
                TmdbRequest.get(TrendingPaths.all(timeWindow)),
                TrendingAllResponse.class
        );
    }

    @Override
    public TrendingAllResponse all(TrendingTimeWindow timeWindow, Language language) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TrendingPaths.all(timeWindow),
                        QueryParams.create().add("language", language)
                ),
                TrendingAllResponse.class
        );
    }

    @Override
    public TrendingMovieResponse movies(TrendingTimeWindow timeWindow) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");

        return httpClient.get(
                TmdbRequest.get(TrendingPaths.movies(timeWindow)),
                TrendingMovieResponse.class
        );
    }

    @Override
    public TrendingMovieResponse movies(TrendingTimeWindow timeWindow, Language language) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TrendingPaths.movies(timeWindow),
                        QueryParams.create().add("language", language)
                ),
                TrendingMovieResponse.class
        );
    }

    @Override
    public TrendingPersonResponse people(TrendingTimeWindow timeWindow) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");

        return httpClient.get(
                TmdbRequest.get(TrendingPaths.people(timeWindow)),
                TrendingPersonResponse.class
        );
    }

    @Override
    public TrendingPersonResponse people(TrendingTimeWindow timeWindow, Language language) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TrendingPaths.people(timeWindow),
                        QueryParams.create().add("language", language)
                ),
                TrendingPersonResponse.class
        );
    }

    @Override
    public TrendingTvShowResponse tv(TrendingTimeWindow timeWindow) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");

        return httpClient.get(
                TmdbRequest.get(TrendingPaths.tvShows(timeWindow)),
                TrendingTvShowResponse.class
        );
    }

    @Override
    public TrendingTvShowResponse tv(TrendingTimeWindow timeWindow, Language language) {
        Objects.requireNonNull(timeWindow, "Trending time window must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TrendingPaths.tvShows(timeWindow),
                        QueryParams.create().add("language", language)
                ),
                TrendingTvShowResponse.class
        );
    }
}