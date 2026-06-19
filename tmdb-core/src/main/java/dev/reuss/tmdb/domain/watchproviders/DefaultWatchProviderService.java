package dev.reuss.tmdb.domain.watchproviders;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviderRegions;
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviders;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.util.Objects;

/**
 * Default {@link WatchProviderService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultWatchProviderService implements WatchProviderService {

    private final TmdbHttpClient httpClient;

    public DefaultWatchProviderService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public WatchProviderRegions regions() {
        return httpClient.get(
                TmdbRequest.get(WatchProviderPaths.availableRegions()),
                WatchProviderRegions.class
        );
    }

    @Override
    public WatchProviderRegions regions(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.availableRegions(),
                        QueryParams.create().add("language", language)
                ),
                WatchProviderRegions.class
        );
    }

    @Override
    public WatchProviders movies() {
        return httpClient.get(
                TmdbRequest.get(WatchProviderPaths.movieProviders()),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders movies(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.movieProviders(),
                        QueryParams.create().add("language", language)
                ),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders movies(Region watchRegion) {
        Objects.requireNonNull(watchRegion, "Watch region must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.movieProviders(),
                        QueryParams.create().add("watch_region", watchRegion)
                ),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders movies(Region watchRegion, Language language) {
        Objects.requireNonNull(watchRegion, "Watch region must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.movieProviders(),
                        QueryParams.create()
                                .add("watch_region", watchRegion)
                                .add("language", language)
                ),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders tv() {
        return httpClient.get(
                TmdbRequest.get(WatchProviderPaths.tvProviders()),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders tv(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.tvProviders(),
                        QueryParams.create().add("language", language)
                ),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders tv(Region watchRegion) {
        Objects.requireNonNull(watchRegion, "Watch region must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.tvProviders(),
                        QueryParams.create().add("watch_region", watchRegion)
                ),
                WatchProviders.class
        );
    }

    @Override
    public WatchProviders tv(Region watchRegion, Language language) {
        Objects.requireNonNull(watchRegion, "Watch region must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        WatchProviderPaths.tvProviders(),
                        QueryParams.create()
                                .add("watch_region", watchRegion)
                                .add("language", language)
                ),
                WatchProviders.class
        );
    }
}
