package dev.reuss.tmdb.domain.tv.episodegroup

import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupDetails
import dev.reuss.tmdb.value.id.TvEpisodeGroupId

/**
 * Default [TvEpisodeGroupService] implementation backed by TMDB HTTP requests.
 */
internal class DefaultTvEpisodeGroupService(
    private val httpClient: TmdbHttpClient
) : TvEpisodeGroupService {

    override fun details(episodeGroupId: TvEpisodeGroupId): TvEpisodeGroupDetails =
        httpClient.get(
            TmdbRequest.get(TvEpisodeGroupPaths.details(episodeGroupId)),
            TvEpisodeGroupDetails::class.java
        )
}