package dev.reuss.tmdb.domain.trending

import dev.reuss.tmdb.domain.trending.model.TrendingAllResponse
import dev.reuss.tmdb.domain.trending.model.TrendingMovieResponse
import dev.reuss.tmdb.domain.trending.model.TrendingPersonResponse
import dev.reuss.tmdb.domain.trending.model.TrendingTimeWindow
import dev.reuss.tmdb.domain.trending.model.TrendingTvShowResponse
import dev.reuss.tmdb.value.language.Language

/**
 * Service for loading TMDB trending media.
 */
interface TrendingService {
    /**
     * Loads trending media across movies, TV shows and people.
     *
     * @param timeWindow trending time window
     * @return trending media
     */
    fun all(timeWindow: TrendingTimeWindow): TrendingAllResponse

    /**
     * Loads trending media across movies, TV shows and people using a specific language.
     *
     * @param timeWindow trending time window
     * @param language response language
     * @return trending media
     */
    fun all(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingAllResponse

    /**
     * Loads trending movies.
     *
     * @param timeWindow trending time window
     * @return trending movies
     */
    fun movies(timeWindow: TrendingTimeWindow): TrendingMovieResponse

    /**
     * Loads trending movies using a specific language.
     *
     * @param timeWindow trending time window
     * @param language response language
     * @return trending movies
     */
    fun movies(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingMovieResponse

    /**
     * Loads trending people.
     *
     * @param timeWindow trending time window
     * @return trending people
     */
    fun people(timeWindow: TrendingTimeWindow): TrendingPersonResponse

    /**
     * Loads trending people using a specific language.
     *
     * @param timeWindow trending time window
     * @param language response language
     * @return trending people
     */
    fun people(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingPersonResponse

    /**
     * Loads trending TV shows.
     *
     * @param timeWindow trending time window
     * @return trending TV shows
     */
    fun tv(timeWindow: TrendingTimeWindow): TrendingTvShowResponse

    /**
     * Loads trending TV shows using a specific language.
     *
     * @param timeWindow trending time window
     * @param language response language
     * @return trending TV shows
     */
    fun tv(
        timeWindow: TrendingTimeWindow,
        language: Language,
    ): TrendingTvShowResponse
}
