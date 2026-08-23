package dev.reuss.tmdb.domain.watchproviders.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB watch provider list.
 *
 * @property results watch providers
 */
@JvmRecord
data class WatchProviders(
    @all:JsonProperty("results")
    val results: List<WatchProvider> = emptyList()
) : TmdbModel
