package dev.reuss.tmdb.domain.tv.episodegroup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Episode group inside a TV episode group.
 *
 * @param id       group id
 * @param name     group name
 * @param order    group order
 * @param episodes grouped episodes
 * @param locked   whether the group is locked
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeGroup(
        String id,
        String name,
        int order,
        List<TvEpisodeGroupEpisode> episodes,
        boolean locked
) implements TmdbModel {

    public TvEpisodeGroup {
        episodes = TmdbCollections.list(episodes);
    }
}