package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV series episodes that have screened theatrically.
 *
 * @property id TMDB TV series id
 * @property results theatrically screened episodes
 */
@JvmRecord
data class TvSeriesScreenedTheatrically(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    val results: List<TvSeriesScreenedTheatricallyEpisode> = emptyList(),
) : TmdbModel
