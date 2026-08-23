package dev.reuss.tmdb.domain.tv.episodegroup

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.TvEpisodeGroupId

internal object TvEpisodeGroupPaths {
    fun details(episodeGroupId: TvEpisodeGroupId): String = tmdbPath("tv", "episode_group", episodeGroupId)
}
