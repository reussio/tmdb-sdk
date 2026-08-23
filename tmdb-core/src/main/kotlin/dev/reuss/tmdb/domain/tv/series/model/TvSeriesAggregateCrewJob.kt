package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate crew job for a TMDB TV series.
 *
 * @property creditId TMDB credit id
 * @property job crew job
 * @property episodeCount episode count
 */
@JvmRecord
data class TvSeriesAggregateCrewJob(
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("job")
    val job: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
) : TmdbModel
