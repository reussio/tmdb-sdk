package dev.reuss.tmdb.domain.genres

import dev.reuss.tmdb.core.path.tmdbPath

internal object GenrePaths {
    fun movieGenres(): String = tmdbPath("genre", "movie", "list")

    fun tvSeriesGenres(): String = tmdbPath("genre", "tv", "list")
}
