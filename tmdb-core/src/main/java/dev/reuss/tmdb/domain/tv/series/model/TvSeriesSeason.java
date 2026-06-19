package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Lightweight TV season representation used in TV series details.
 *
 * @param airDate season air date
 * @param episodeCount episode count
 * @param id TMDB season id
 * @param name season name
 * @param overview season overview
 * @param posterPath poster image path
 * @param seasonNumber season number
 * @param voteAverage vote average
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesSeason(
        @JsonProperty("air_date")
        String airDate,

        @JsonProperty("episode_count")
        int episodeCount,

        int id,

        String name,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("season_number")
        int seasonNumber,

        @JsonProperty("vote_average")
        double voteAverage
) implements TmdbModel {
}
