package dev.reuss.tmdb.domain.networks

import dev.reuss.tmdb.common.image.NetworkImages
import dev.reuss.tmdb.domain.networks.model.Network
import dev.reuss.tmdb.domain.networks.model.NetworkAlternativeNames
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.NetworkId
import org.junit.jupiter.api.Test

class DefaultNetworkServiceTest {
    private val networkId = NetworkId.of(49)

    @Test
    fun networkMethods_shouldUseExpectedPathsAndResponseTypes() {
        assertRequest<Network>("/network/49") {
            DefaultNetworkService(it).details(networkId)
        }
        assertRequest<NetworkAlternativeNames>("/network/49/alternative_names") {
            DefaultNetworkService(it).alternativeNames(networkId)
        }
        assertRequest<NetworkImages>("/network/49/images") {
            DefaultNetworkService(it).images(networkId)
        }
    }
}
