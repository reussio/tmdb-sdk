package dev.reuss.tmdb.domain.trending

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.domain.trending.model.TrendingTimeWindow

internal object TrendingPaths {
    fun movies(timeWindow: TrendingTimeWindow): String = tmdbPath("trending", "movie", timeWindow.value)

    fun tvShows(timeWindow: TrendingTimeWindow): String = tmdbPath("trending", "tv", timeWindow.value)

    fun people(timeWindow: TrendingTimeWindow): String = tmdbPath("trending", "person", timeWindow.value)

    fun all(timeWindow: TrendingTimeWindow): String = tmdbPath("trending", "all", timeWindow.value)
}
