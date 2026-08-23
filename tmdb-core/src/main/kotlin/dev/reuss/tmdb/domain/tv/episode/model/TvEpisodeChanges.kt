package dev.reuss.tmdb.domain.tv.episode.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.change.Change
import dev.reuss.tmdb.common.change.ChangesResponse

/**
 * Changes for a TMDB TV episode.
 *
 * @property changes TV episode changes
 */
@JvmRecord
data class TvEpisodeChanges(
    @all:JsonProperty("changes")
    override val changes: List<Change> = emptyList()
) : ChangesResponse, TmdbModel
