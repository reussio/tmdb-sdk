package dev.reuss.tmdb.domain.trending;

import dev.reuss.tmdb.domain.trending.model.*;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for loading TMDB trending media.
 */
public interface TrendingService {

    TrendingAllResponse all(TrendingTimeWindow timeWindow);

    TrendingAllResponse all(TrendingTimeWindow timeWindow, Language language);

    /**
     * Loads trending movies.
     *
     * @param timeWindow trending time window
     * @return trending movies
     */
    TrendingMovieResponse movies(TrendingTimeWindow timeWindow);

    /**
     * Loads trending movies using a specific language.
     *
     * @param timeWindow trending time window
     * @param language   response language
     * @return trending movies
     */
    TrendingMovieResponse movies(TrendingTimeWindow timeWindow, Language language);

    /**
     * Loads trending people.
     *
     * @param timeWindow trending time window
     * @return trending people
     */
    TrendingPersonResponse people(TrendingTimeWindow timeWindow);

    /**
     * Loads trending people using a specific language.
     *
     * @param timeWindow trending time window
     * @param language   response language
     * @return trending people
     */
    TrendingPersonResponse people(TrendingTimeWindow timeWindow, Language language);

    /**
     * Loads trending TV shows.
     *
     * @param timeWindow trending time window
     * @return trending TV shows
     */
    TrendingTvShowResponse tv(TrendingTimeWindow timeWindow);

    /**
     * Loads trending TV shows using a specific language.
     *
     * @param timeWindow trending time window
     * @param language   response language
     * @return trending TV shows
     */
    TrendingTvShowResponse tv(TrendingTimeWindow timeWindow, Language language);
}
