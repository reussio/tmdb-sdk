package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.change.Change
import dev.reuss.tmdb.common.change.ChangesResponse

/**
 * Changes for a TMDB movie.
 *
 * @property changes movie changes
 */
@JvmRecord
data class MovieChanges(
    @all:JsonProperty("changes")
    override val changes: List<Change> = emptyList(),
) : ChangesResponse,
    TmdbModel
