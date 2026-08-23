package dev.reuss.tmdb.domain.networks.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel

/**
 * Alternative name for a TMDB network.
 *
 * @property name alternative network name
 * @property type optional name type
 */
@JvmRecord
data class NetworkAlternativeName(
    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("type")
    val type: String?
) : TmdbModel
