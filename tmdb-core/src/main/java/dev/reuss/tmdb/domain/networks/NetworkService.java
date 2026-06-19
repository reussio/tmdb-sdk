package dev.reuss.tmdb.domain.networks;

import dev.reuss.tmdb.common.image.NetworkImages;
import dev.reuss.tmdb.domain.networks.model.Network;
import dev.reuss.tmdb.domain.networks.model.NetworkAlternativeNames;
import dev.reuss.tmdb.value.id.NetworkId;

/**
 * Service for loading TMDB network metadata.
 */
public interface NetworkService {

    /**
     * Loads network details by network id.
     *
     * @param networkId the network id
     * @return network details
     */
    Network details(NetworkId networkId);

    /**
     * Loads alternative names for a network.
     *
     * @param networkId the network id
     * @return alternative network names
     */
    NetworkAlternativeNames alternativeNames(NetworkId networkId);

    NetworkImages images(NetworkId networkId);

}
