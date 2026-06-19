package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Lightweight TV episode representation used in TV series details.
 *
 * @param id TMDB episode id
 * @param name episode name
 * @param overview episode overview
 * @param voteAverage vote average
 * @param voteCount vote count
 * @param airDate episode air date
 * @param episodeNumber episode number
 * @param productionCode production code
 * @param runtime runtime in minutes
 * @param seasonNumber season number
 * @param showId TMDB TV series id
 * @param stillPath still image path
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesEpisode(
        int id,

        String name,

        String overview,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("air_date")
        String airDate,

        @JsonProperty("episode_number")
        int episodeNumber,

        @JsonProperty("production_code")
        String productionCode,

        Integer runtime,

        @JsonProperty("season_number")
        int seasonNumber,

        @JsonProperty("show_id")
        int showId,

        @JsonProperty("still_path")
        String stillPath
) implements TmdbModel {
}
