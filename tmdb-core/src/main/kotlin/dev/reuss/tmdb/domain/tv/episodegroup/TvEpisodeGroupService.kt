package dev.reuss.tmdb.domain.tv.episodegroup

import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupDetails
import dev.reuss.tmdb.value.id.TvEpisodeGroupId

/**
 * Service for TMDB TV episode group endpoints.
 */
interface TvEpisodeGroupService {

    /**
     * Loads details for a TV episode group.
     *
     * @param episodeGroupId the TV episode group id
     * @return TV episode group details
     */
    fun details(episodeGroupId: TvEpisodeGroupId): TvEpisodeGroupDetails
}