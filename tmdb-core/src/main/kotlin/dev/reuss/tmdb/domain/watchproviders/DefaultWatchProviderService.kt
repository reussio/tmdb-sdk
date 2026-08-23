package dev.reuss.tmdb.domain.watchproviders

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviderRegions
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviders
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Default [WatchProviderService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultWatchProviderService(
    private val httpClient: TmdbHttpClient
) : WatchProviderService {

    override fun regions(): WatchProviderRegions =
        httpClient.get(
            TmdbRequest.get(WatchProviderPaths.availableRegions()),
            WatchProviderRegions::class.java
        )

    override fun regions(language: Language): WatchProviderRegions =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.availableRegions(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            WatchProviderRegions::class.java
        )

    override fun movies(): WatchProviders =
        httpClient.get(
            TmdbRequest.get(WatchProviderPaths.movieProviders()),
            WatchProviders::class.java
        )

    override fun movies(language: Language): WatchProviders =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.movieProviders(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            WatchProviders::class.java
        )

    override fun movies(watchRegion: Region): WatchProviders =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.movieProviders(),
                QueryParams.create()
                    .add("watch_region", watchRegion.value)
            ),
            WatchProviders::class.java
        )

    override fun movies(
        watchRegion: Region,
        language: Language
    ): WatchProviders =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.movieProviders(),
                QueryParams.create()
                    .add("watch_region", watchRegion.value)
                    .add("language", language.value)
            ),
            WatchProviders::class.java
        )

    override fun tv(): WatchProviders =
        httpClient.get(
            TmdbRequest.get(WatchProviderPaths.tvProviders()),
            WatchProviders::class.java
        )

    override fun tv(language: Language): WatchProviders =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.tvProviders(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            WatchProviders::class.java
        )

    override fun tv(watchRegion: Region): WatchProviders =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.tvProviders(),
                QueryParams.create()
                    .add("watch_region", watchRegion.value)
            ),
            WatchProviders::class.java
        )

    override fun tv(
        watchRegion: Region,
        language: Language
    ): WatchProviders =
        httpClient.get(
            TmdbRequest.get(
                WatchProviderPaths.tvProviders(),
                QueryParams.create()
                    .add("watch_region", watchRegion.value)
                    .add("language", language.value)
            ),
            WatchProviders::class.java
        )
}