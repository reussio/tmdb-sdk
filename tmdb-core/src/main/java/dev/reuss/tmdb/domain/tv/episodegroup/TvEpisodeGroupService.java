package dev.reuss.tmdb.domain.tv.episodegroup;

import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupDetails;
import dev.reuss.tmdb.value.id.TvEpisodeGroupId;

public interface TvEpisodeGroupService {

    /**
     * Loads details for a TV episode group.
     *
     * @param episodeGroupId the TV episode group id
     * @return TV episode group details
     */
    TvEpisodeGroupDetails details(TvEpisodeGroupId episodeGroupId);
}
