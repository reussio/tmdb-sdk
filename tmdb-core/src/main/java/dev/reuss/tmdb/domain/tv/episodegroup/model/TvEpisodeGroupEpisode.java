package dev.reuss.tmdb.domain.tv.episodegroup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Episode inside a TV episode group.
 *
 * @param airDate        episode air date
 * @param episodeNumber  episode number
 * @param id             TMDB episode id
 * @param name           episode name
 * @param overview       episode overview
 * @param productionCode production code
 * @param runtime        runtime in minutes
 * @param seasonNumber   season number
 * @param showId         TMDB show id
 * @param stillPath      still image path
 * @param voteAverage    vote average
 * @param voteCount      vote count
 * @param order          episode order inside the group
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeGroupEpisode(
        @JsonProperty("air_date")
        String airDate,

        @JsonProperty("episode_number")
        int episodeNumber,

        int id,

        String name,

        String overview,

        @JsonProperty("production_code")
        String productionCode,

        Integer runtime,

        @JsonProperty("season_number")
        int seasonNumber,

        @JsonProperty("show_id")
        int showId,

        @JsonProperty("still_path")
        String stillPath,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        int order
) implements TmdbModel {
}
