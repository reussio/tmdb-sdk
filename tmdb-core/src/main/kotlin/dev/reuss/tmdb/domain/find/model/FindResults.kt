package dev.reuss.tmdb.domain.find.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Results returned by TMDB find.
 *
 * @property movieResults matching movies
 * @property personResults matching people
 * @property tvResults matching TV series
 * @property tvEpisodeResults matching TV episodes
 * @property tvSeasonResults matching TV seasons
 */
@JvmRecord
data class FindResults(
    @all:JsonProperty("movie_results")
    val movieResults: List<FindMovieResult> = emptyList(),
    @all:JsonProperty("person_results")
    val personResults: List<Any> = emptyList(),
    @all:JsonProperty("tv_results")
    val tvResults: List<Any> = emptyList(),
    @all:JsonProperty("tv_episode_results")
    val tvEpisodeResults: List<Any> = emptyList(),
    @all:JsonProperty("tv_season_results")
    val tvSeasonResults: List<Any> = emptyList(),
) : TmdbModel
