package dev.reuss.tmdb.domain.watchproviders.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB watch provider.
 *
 * @property displayPriorities region-specific display priorities
 * @property displayPriority default display priority
 * @property logoPath TMDB image path for the logo.
 * @property providerName provider name
 * @property providerId TMDB provider id
 */
@JvmRecord
data class WatchProvider(
    @all:JsonProperty("display_priorities")
    val displayPriorities: Map<String, Int> = emptyMap(),
    @all:JsonProperty("display_priority")
    val displayPriority: Int,
    @all:JsonProperty("logo_path")
    val logoPath: String?,
    @all:JsonProperty("provider_name")
    val providerName: String?,
    @all:JsonProperty("provider_id")
    val providerId: Int,
) : TmdbModel
