package dev.reuss.tmdb.domain.networks.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.name.AlternativeNamesResponse

/**
 * Alternative names for a TMDB network.
 *
 * @property id TMDB network id
 * @property results alternative network names
 */
@JvmRecord
data class NetworkAlternativeNames(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    override val results: List<NetworkAlternativeName> = emptyList(),
) : AlternativeNamesResponse<NetworkAlternativeName>,
    TmdbModel
