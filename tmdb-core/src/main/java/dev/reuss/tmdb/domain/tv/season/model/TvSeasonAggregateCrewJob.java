package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Aggregate crew job for a TV season.
 *
 * @param creditId     credit id
 * @param job          job
 * @param episodeCount episode count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonAggregateCrewJob(
        @JsonProperty("credit_id")
        String creditId,

        String job,

        @JsonProperty("episode_count")
        int episodeCount
) implements TmdbModel {
}