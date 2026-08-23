package dev.reuss.tmdb.domain.tv.season

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.TvSeasonId
import dev.reuss.tmdb.value.id.TvShowId

internal object TvSeasonPaths {

    fun details(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath("tv", tvShowId, "season", seasonNumber)

    fun aggregateCredits(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "aggregate_credits"
        )

    fun changes(seasonId: TvSeasonId): String =
        tmdbPath("tv", "season", seasonId, "changes")

    fun credits(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath("tv", tvShowId, "season", seasonNumber, "credits")

    fun externalIds(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath("tv", tvShowId, "season", seasonNumber, "external_ids")

    fun images(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath("tv", tvShowId, "season", seasonNumber, "images")

    fun translations(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath("tv", tvShowId, "season", seasonNumber, "translations")

    fun videos(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath("tv", tvShowId, "season", seasonNumber, "videos")

    fun watchProviders(
        tvShowId: TvShowId,
        seasonNumber: Int
    ): String =
        tmdbPath(
            "tv",
            tvShowId,
            "season",
            seasonNumber,
            "watch",
            "providers"
        )
}