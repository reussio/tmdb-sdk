package dev.reuss.tmdb.domain.find.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Results returned by TMDB find.
 *
 * @param movieResults     matching movies
 * @param personResults    matching people
 * @param tvResults        matching TV shows
 * @param tvEpisodeResults matching TV episodes
 * @param tvSeasonResults  matching TV seasons
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FindResults(
        @JsonProperty("movie_results")
        List<FindMovieResult> movieResults,

        @JsonProperty("person_results")
        List<Object> personResults,

        @JsonProperty("tv_results")
        List<Object> tvResults,

        @JsonProperty("tv_episode_results")
        List<Object> tvEpisodeResults,

        @JsonProperty("tv_season_results")
        List<Object> tvSeasonResults
) implements TmdbModel {

    public FindResults {
        movieResults = TmdbCollections.list(movieResults);
        personResults = TmdbCollections.list(personResults);
        tvResults = TmdbCollections.list(tvResults);
        tvEpisodeResults = TmdbCollections.list(tvEpisodeResults);
        tvSeasonResults = TmdbCollections.list(tvSeasonResults);
    }
}
