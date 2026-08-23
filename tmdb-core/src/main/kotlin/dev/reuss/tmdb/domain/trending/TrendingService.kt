package dev.reuss.tmdb.domain.trending

import dev.reuss.tmdb.domain.trending.model.TrendingAllResponse
import dev.reuss.tmdb.domain.trending.model.TrendingMovieResponse
import dev.reuss.tmdb.domain.trending.model.TrendingPersonResponse
import dev.reuss.tmdb.domain.trending.model.TrendingTimeWindow
import dev.reuss.tmdb.domain.trending.model.TrendingTvShowResponse
import dev.reuss.tmdb.value.language.Language

/**
 * Loads the movies, people, and TV series receiving the most activity on TMDB during a day or
 * week.
 */
interface TrendingService {
    /** Returns trending movies, people, and TV series using the client's default language. */
    fun all(timeWindow: TrendingTimeWindow): TrendingAllResponse

    /** Returns trending movies, people, and TV series localized in [language]. */
    fun all(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingAllResponse

    /** Returns trending movies using the client's default language. */
    fun movies(timeWindow: TrendingTimeWindow): TrendingMovieResponse

    /** Returns trending movies localized in [language]. */
    fun movies(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingMovieResponse

    /** Returns trending people using the client's default language. */
    fun people(timeWindow: TrendingTimeWindow): TrendingPersonResponse

    /** Returns trending people localized in [language]. */
    fun people(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingPersonResponse

    /** Returns trending TV series using the client's default language. */
    fun tv(timeWindow: TrendingTimeWindow): TrendingTvShowResponse

    /** Returns trending TV series localized in [language]. */
    fun tv(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingTvShowResponse
}
