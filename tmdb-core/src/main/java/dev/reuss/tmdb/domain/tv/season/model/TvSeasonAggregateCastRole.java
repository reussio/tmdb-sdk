package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Aggregate cast role for a TV season.
 *
 * @param creditId     credit id
 * @param character    character name
 * @param episodeCount episode count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonAggregateCastRole(
        @JsonProperty("credit_id")
        String creditId,

        String character,

        @JsonProperty("episode_count")
        int episodeCount
) implements TmdbModel {
}
