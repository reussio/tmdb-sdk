package dev.reuss.tmdb.domain.trending

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.trending.model.*
import dev.reuss.tmdb.value.language.Language

/**
 * Default [TrendingService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultTrendingService(
    private val httpClient: TmdbHttpClient
) : TrendingService {

    override fun all(timeWindow: TrendingTimeWindow): TrendingAllResponse =
        httpClient.get(
            TmdbRequest.get(TrendingPaths.all(timeWindow)),
            TrendingAllResponse::class.java
        )

    override fun all(
        timeWindow: TrendingTimeWindow,
        language: Language
    ): TrendingAllResponse =
        httpClient.get(
            TmdbRequest.get(
                TrendingPaths.all(timeWindow),
                QueryParams.create()
                    .add("language", language.value)
            ),
            TrendingAllResponse::class.java
        )

    override fun movies(timeWindow: TrendingTimeWindow): TrendingMovieResponse =
        httpClient.get(
            TmdbRequest.get(TrendingPaths.movies(timeWindow)),
            TrendingMovieResponse::class.java
        )

    override fun movies(
        timeWindow: TrendingTimeWindow,
        language: Language
    ): TrendingMovieResponse =
        httpClient.get(
            TmdbRequest.get(
                TrendingPaths.movies(timeWindow),
                QueryParams.create()
                    .add("language", language.value)
            ),
            TrendingMovieResponse::class.java
        )

    override fun people(timeWindow: TrendingTimeWindow): TrendingPersonResponse =
        httpClient.get(
            TmdbRequest.get(TrendingPaths.people(timeWindow)),
            TrendingPersonResponse::class.java
        )

    override fun people(
        timeWindow: TrendingTimeWindow,
        language: Language
    ): TrendingPersonResponse =
        httpClient.get(
            TmdbRequest.get(
                TrendingPaths.people(timeWindow),
                QueryParams.create()
                    .add("language", language.value)
            ),
            TrendingPersonResponse::class.java
        )

    override fun tv(timeWindow: TrendingTimeWindow): TrendingTvShowResponse =
        httpClient.get(
            TmdbRequest.get(TrendingPaths.tvShows(timeWindow)),
            TrendingTvShowResponse::class.java
        )

    override fun tv(
        timeWindow: TrendingTimeWindow,
        language: Language
    ): TrendingTvShowResponse =
        httpClient.get(
            TmdbRequest.get(
                TrendingPaths.tvShows(timeWindow),
                QueryParams.create()
                    .add("language", language.value)
            ),
            TrendingTvShowResponse::class.java
        )
}