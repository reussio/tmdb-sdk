package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Aggregate crew job for a TMDB TV series.
 *
 * @param creditId     TMDB credit id
 * @param job          crew job
 * @param episodeCount episode count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesAggregateCrewJob(
        @JsonProperty("credit_id")
        String creditId,

        String job,

        @JsonProperty("episode_count")
        int episodeCount
) implements TmdbModel {
}