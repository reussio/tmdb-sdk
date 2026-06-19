package dev.reuss.tmdb.domain.networks;

import dev.reuss.tmdb.value.id.NetworkId;

final class NetworkPaths {

    private static final String NETWORK = "/network";

    private NetworkPaths() {
    }

    static String details(NetworkId networkId) {
        return network(networkId);
    }

    static String alternativeNames(NetworkId networkId) {
        return network(networkId) + "/alternative_names";
    }

    static String images(NetworkId networkId) {
        return network(networkId) + "/images";
    }

    private static String network(NetworkId networkId) {
        return NETWORK + "/" + networkId.asString();
    }
}