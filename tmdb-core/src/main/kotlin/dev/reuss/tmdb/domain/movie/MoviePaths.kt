package dev.reuss.tmdb.domain.movie

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.MovieId

internal object MoviePaths {
    fun details(movieId: MovieId): String = tmdbPath("movie", movieId)

    fun alternativeTitles(movieId: MovieId): String = tmdbPath("movie", movieId, "alternative_titles")

    fun changes(movieId: MovieId): String = tmdbPath("movie", movieId, "changes")

    fun credits(movieId: MovieId): String = tmdbPath("movie", movieId, "credits")

    fun externalIds(movieId: MovieId): String = tmdbPath("movie", movieId, "external_ids")

    fun images(movieId: MovieId): String = tmdbPath("movie", movieId, "images")

    fun keywords(movieId: MovieId): String = tmdbPath("movie", movieId, "keywords")

    fun recommendations(movieId: MovieId): String = tmdbPath("movie", movieId, "recommendations")

    fun releaseDates(movieId: MovieId): String = tmdbPath("movie", movieId, "release_dates")

    fun reviews(movieId: MovieId): String = tmdbPath("movie", movieId, "reviews")

    fun similar(movieId: MovieId): String = tmdbPath("movie", movieId, "similar")

    fun translations(movieId: MovieId): String = tmdbPath("movie", movieId, "translations")

    fun videos(movieId: MovieId): String = tmdbPath("movie", movieId, "videos")

    fun watchProviders(movieId: MovieId): String = tmdbPath("movie", movieId, "watch", "providers")

    fun latest(): String = tmdbPath("movie", "latest")

    fun nowPlaying(): String = tmdbPath("movie", "now_playing")

    fun popular(): String = tmdbPath("movie", "popular")

    fun topRated(): String = tmdbPath("movie", "top_rated")

    fun upcoming(): String = tmdbPath("movie", "upcoming")
}
