package dev.reuss.tmdb.domain.tv.episodegroup;

import dev.reuss.tmdb.value.id.TvEpisodeGroupId;

final class TvEpisodeGroupPaths {

    private static final String TV_EPISODE_GROUP = "/tv/episode_group";

    private TvEpisodeGroupPaths() {
    }

    static String details(TvEpisodeGroupId episodeGroupId) {
        return TV_EPISODE_GROUP + "/" + episodeGroupId.asString();
    }
}