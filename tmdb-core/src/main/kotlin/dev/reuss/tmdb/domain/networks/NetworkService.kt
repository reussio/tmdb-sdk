package dev.reuss.tmdb.domain.networks

import dev.reuss.tmdb.common.image.NetworkImages
import dev.reuss.tmdb.domain.networks.model.Network
import dev.reuss.tmdb.domain.networks.model.NetworkAlternativeNames
import dev.reuss.tmdb.value.id.NetworkId

/** Loads TV-network metadata. */
interface NetworkService {
    /** Returns the network identified by [networkId]. */
    fun details(networkId: NetworkId): Network

    /** Returns alternative names recorded for the network. */
    fun alternativeNames(networkId: NetworkId): NetworkAlternativeNames

    /** Returns the network's PNG and SVG logos. */
    fun images(networkId: NetworkId): NetworkImages
}
