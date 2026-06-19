package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * TV episode that has screened theatrically.
 *
 * @param id            TMDB episode id
 * @param episodeNumber episode number
 * @param seasonNumber  season number
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesScreenedTheatricallyEpisode(
        int id,

        @JsonProperty("episode_number")
        int episodeNumber,

        @JsonProperty("season_number")
        int seasonNumber
) implements TmdbModel {
}
