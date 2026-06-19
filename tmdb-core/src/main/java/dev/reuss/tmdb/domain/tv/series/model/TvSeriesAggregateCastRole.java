package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Aggregate cast role for a TMDB TV series.
 *
 * @param creditId     TMDB credit id
 * @param character    character name
 * @param episodeCount episode count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesAggregateCastRole(
        @JsonProperty("credit_id")
        String creditId,

        String character,

        @JsonProperty("episode_count")
        int episodeCount
) implements TmdbModel {
}
