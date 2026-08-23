package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate crew job for a TV season.
 *
 * @property creditId credit id
 * @property job job
 * @property episodeCount Number of associated episodes.
 */
@JvmRecord
data class TvSeasonAggregateCrewJob(
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("job")
    val job: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
) : TmdbModel
