package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate cast role for a TV season.
 *
 * @property creditId credit id
 * @property character character name
 * @property episodeCount episode count
 */
@JvmRecord
data class TvSeasonAggregateCastRole(
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("character")
    val character: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
) : TmdbModel
