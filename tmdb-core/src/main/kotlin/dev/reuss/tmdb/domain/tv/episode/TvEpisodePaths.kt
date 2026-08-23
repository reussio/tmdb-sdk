package dev.reuss.tmdb.domain.tv.episode

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.TvEpisodeId
import dev.reuss.tmdb.value.id.TvShowId

internal object TvEpisodePaths {
    fun details(
        tvShowId: TvShowId,
        seasonNumber: Int,
        episodeNumber: Int,
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "episode",
            episodeNumber,
        )

    fun changes(episodeId: TvEpisodeId): String = tmdbPath("tv", "episode", episodeId, "changes")

    fun credits(
        tvShowId: TvShowId,
        seasonNumber: Int,
        episodeNumber: Int,
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "episode",
            episodeNumber,
            "credits",
        )

    fun externalIds(
        tvShowId: TvShowId,
        seasonNumber: Int,
        episodeNumber: Int,
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "episode",
            episodeNumber,
            "external_ids",
        )

    fun images(
        tvShowId: TvShowId,
        seasonNumber: Int,
        episodeNumber: Int,
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "episode",
            episodeNumber,
            "images",
        )

    fun translations(
        tvShowId: TvShowId,
        seasonNumber: Int,
        episodeNumber: Int,
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "episode",
            episodeNumber,
            "translations",
        )

    fun videos(
        tvShowId: TvShowId,
        seasonNumber: Int,
        episodeNumber: Int,
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "episode",
            episodeNumber,
            "videos",
        )
}
