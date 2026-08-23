package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.change.Change
import dev.reuss.tmdb.common.change.ChangesResponse

/**
 * Changes for a TMDB TV season.
 *
 * @property changes TV season changes
 */
@JvmRecord
data class TvSeasonChanges(
    @all:JsonProperty("changes")
    override val changes: List<Change> = emptyList(),
) : ChangesResponse,
    TmdbModel
