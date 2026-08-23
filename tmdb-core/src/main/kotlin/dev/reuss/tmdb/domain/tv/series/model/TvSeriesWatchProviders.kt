package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.watchprovider.WatchProviderAvailability
import dev.reuss.tmdb.common.watchprovider.WatchProvidersResponse

/**
 * Watch provider availabilities for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property results watch providers grouped by region code
 */
@JvmRecord
data class TvSeriesWatchProviders(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("results")
    override val results: Map<String, WatchProviderAvailability> = emptyMap()
) : WatchProvidersResponse<WatchProviderAvailability>, TmdbModel
