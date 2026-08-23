package dev.reuss.tmdb.domain.watchproviders.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Available TMDB watch provider regions.
 *
 * @property results available regions
 */
@JvmRecord
data class WatchProviderRegions(
    @all:JsonProperty("results")
    val results: List<WatchProviderRegion> = emptyList(),
) : TmdbModel
