package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.watchprovider.WatchProviderAvailability
import dev.reuss.tmdb.common.watchprovider.WatchProvidersResponse

/**
 * Watch provider availabilities for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property results watch providers grouped by region code
 */
@JvmRecord
data class MovieWatchProviders(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    override val results: Map<String, WatchProviderAvailability> = emptyMap(),
) : WatchProvidersResponse<WatchProviderAvailability>,
    TmdbModel
