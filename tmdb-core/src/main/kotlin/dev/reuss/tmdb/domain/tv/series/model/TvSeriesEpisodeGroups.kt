package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Episode groups for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property results episode groups
 */
@JvmRecord
data class TvSeriesEpisodeGroups(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    val results: List<TvSeriesEpisodeGroup> = emptyList(),
) : TmdbModel
