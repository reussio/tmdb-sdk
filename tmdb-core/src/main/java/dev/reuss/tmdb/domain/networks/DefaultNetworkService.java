package dev.reuss.tmdb.domain.networks;

import dev.reuss.tmdb.common.image.NetworkImages;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.networks.model.Network;
import dev.reuss.tmdb.domain.networks.model.NetworkAlternativeNames;
import dev.reuss.tmdb.value.id.NetworkId;

import java.util.Objects;

/**
 * Default {@link NetworkService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultNetworkService implements NetworkService {

    private final TmdbHttpClient httpClient;

    public DefaultNetworkService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public Network details(NetworkId networkId) {
        Objects.requireNonNull(networkId, "Network id must not be null");

        return httpClient.get(
                TmdbRequest.get(NetworkPaths.details(networkId)),
                Network.class
        );
    }

    @Override
    public NetworkAlternativeNames alternativeNames(NetworkId networkId) {
        Objects.requireNonNull(networkId, "Network id must not be null");

        return httpClient.get(
                TmdbRequest.get(NetworkPaths.alternativeNames(networkId)),
                NetworkAlternativeNames.class
        );
    }

    @Override
    public NetworkImages images(NetworkId networkId) {
        Objects.requireNonNull(networkId, "Network id must not be null");

        return httpClient.get(
                TmdbRequest.get(NetworkPaths.images(networkId)),
                NetworkImages.class
        );
    }
}