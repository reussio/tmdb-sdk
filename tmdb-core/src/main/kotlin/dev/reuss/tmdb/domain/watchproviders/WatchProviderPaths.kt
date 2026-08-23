package dev.reuss.tmdb.domain.watchproviders

import dev.reuss.tmdb.core.path.tmdbPath

internal object WatchProviderPaths {

    fun availableRegions(): String =
        tmdbPath("watch", "providers", "regions")

    fun movieProviders(): String =
        tmdbPath("watch", "providers", "movie")

    fun tvProviders(): String =
        tmdbPath("watch", "providers", "tv")
}