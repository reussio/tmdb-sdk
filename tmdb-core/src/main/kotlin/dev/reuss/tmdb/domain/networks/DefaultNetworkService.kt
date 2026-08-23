package dev.reuss.tmdb.domain.networks

import dev.reuss.tmdb.common.image.NetworkImages
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.networks.model.Network
import dev.reuss.tmdb.domain.networks.model.NetworkAlternativeNames
import dev.reuss.tmdb.value.id.NetworkId

/**
 * Default [NetworkService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultNetworkService(
    private val httpClient: TmdbHttpClient,
) : NetworkService {
    override fun details(networkId: NetworkId): Network =
        httpClient.get(
            TmdbRequest.get(NetworkPaths.details(networkId)),
            Network::class.java,
        )

    override fun alternativeNames(networkId: NetworkId): NetworkAlternativeNames =
        httpClient.get(
            TmdbRequest.get(NetworkPaths.alternativeNames(networkId)),
            NetworkAlternativeNames::class.java,
        )

    override fun images(networkId: NetworkId): NetworkImages =
        httpClient.get(
            TmdbRequest.get(NetworkPaths.images(networkId)),
            NetworkImages::class.java,
        )
}
