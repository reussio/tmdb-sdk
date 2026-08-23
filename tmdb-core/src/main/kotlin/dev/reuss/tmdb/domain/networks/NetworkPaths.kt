package dev.reuss.tmdb.domain.networks

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.NetworkId

internal object NetworkPaths {

    fun details(networkId: NetworkId): String =
        tmdbPath("network", networkId)

    fun alternativeNames(networkId: NetworkId): String =
        tmdbPath("network", networkId, "alternative_names")

    fun images(networkId: NetworkId): String =
        tmdbPath("network", networkId, "images")
}