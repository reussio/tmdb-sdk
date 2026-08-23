package dev.reuss.tmdb.domain.discover

import dev.reuss.tmdb.core.path.tmdbPath

internal object DiscoverPaths {

    fun movies(): String =
        tmdbPath("discover", "movie")

    fun tvSeries(): String =
        tmdbPath("discover", "tv")
}