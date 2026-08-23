package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.change.Change
import dev.reuss.tmdb.common.change.ChangesResponse

/**
 * Recent changes for a TMDB TV series.
 *
 * @property changes changed TV series fields
 */
@JvmRecord
data class TvSeriesChanges(
    @all:JsonProperty("changes")
    override val changes: List<Change> = emptyList(),
) : ChangesResponse,
    TmdbModel
