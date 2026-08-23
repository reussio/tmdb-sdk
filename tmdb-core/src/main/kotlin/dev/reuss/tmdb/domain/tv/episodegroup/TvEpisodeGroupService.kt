package dev.reuss.tmdb.domain.tv.episodegroup

import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupDetails
import dev.reuss.tmdb.value.id.TvEpisodeGroupId

/** Loads alternative groupings of TV episodes, such as DVD or production order. */
interface TvEpisodeGroupService {
    /** Returns the episode group identified by [episodeGroupId]. */
    fun details(episodeGroupId: TvEpisodeGroupId): TvEpisodeGroupDetails
}
