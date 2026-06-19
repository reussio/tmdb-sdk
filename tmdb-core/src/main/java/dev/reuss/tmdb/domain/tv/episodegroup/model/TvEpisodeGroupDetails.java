package dev.reuss.tmdb.domain.tv.episodegroup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Details for a TMDB TV episode group.
 *
 * @param description  episode group description
 * @param episodeCount total episode count
 * @param groupCount   total group count
 * @param groups       episode groups
 * @param id           TMDB episode group id
 * @param name         episode group name
 * @param network      network
 * @param type         episode group type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeGroupDetails(
        String description,

        @JsonProperty("episode_count")
        int episodeCount,

        @JsonProperty("group_count")
        int groupCount,

        List<TvEpisodeGroup> groups,

        String id,

        String name,

        TvEpisodeGroupNetwork network,

        int type
) implements TmdbModel {

    public TvEpisodeGroupDetails {
        groups = TmdbCollections.list(groups);
    }

    public TvEpisodeGroupType episodeGroupType() {
        return TvEpisodeGroupType.fromValue(type);
    }
}