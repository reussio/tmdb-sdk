package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Episode group for a TMDB TV series.
 *
 * @param description  group description
 * @param episodeCount episode count
 * @param groupCount   group count
 * @param id           TMDB episode group id
 * @param name         group name
 * @param network      related network
 * @param type         group type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesEpisodeGroup(
        String description,

        @JsonProperty("episode_count")
        int episodeCount,

        @JsonProperty("group_count")
        int groupCount,

        String id,

        String name,

        TvSeriesNetwork network,

        int type
) implements TmdbModel {
}