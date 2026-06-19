package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Lightweight TV episode representation used in TV series details.
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