package dev.reuss.tmdb.domain.tv.series

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.TvShowId

internal object TvSeriesPaths {

    fun details(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId)

    fun aggregateCredits(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "aggregate_credits")

    fun alternativeTitles(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "alternative_titles")

    fun changes(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "changes")

    fun contentRatings(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "content_ratings")

    fun credits(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "credits")

    fun episodeGroups(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "episode_groups")

    fun externalIds(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "external_ids")

    fun images(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "images")

    fun keywords(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "keywords")

    fun recommendations(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "recommendations")

    fun reviews(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "reviews")

    fun screenedTheatrically(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "screened_theatrically")

    fun similar(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "similar")

    fun translations(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "translations")

    fun videos(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "videos")

    fun watchProviders(tvShowId: TvShowId): String =
        tmdbPath("tv", tvShowId, "watch", "providers")

    fun airingToday(): String =
        tmdbPath("tv", "airing_today")

    fun latest(): String =
        tmdbPath("tv", "latest")

    fun onTheAir(): String =
        tmdbPath("tv", "on_the_air")

    fun popular(): String =
        tmdbPath("tv", "popular")

    fun topRated(): String =
        tmdbPath("tv", "top_rated")
}