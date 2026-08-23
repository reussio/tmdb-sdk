package dev.reuss.tmdb.domain.search

import dev.reuss.tmdb.core.path.tmdbPath

internal object SearchPaths {

    fun companies(): String =
        tmdbPath("search", "company")

    fun collections(): String =
        tmdbPath("search", "collection")

    fun keywords(): String =
        tmdbPath("search", "keyword")

    fun movies(): String =
        tmdbPath("search", "movie")

    fun multi(): String =
        tmdbPath("search", "multi")

    fun people(): String =
        tmdbPath("search", "person")

    fun tvShows(): String =
        tmdbPath("search", "tv")
}