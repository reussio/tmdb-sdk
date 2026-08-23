package dev.reuss.tmdb.query

import dev.reuss.tmdb.domain.movie.MovieAppend
import dev.reuss.tmdb.domain.people.PersonAppend
import dev.reuss.tmdb.domain.tv.episode.TvEpisodeAppend
import dev.reuss.tmdb.domain.tv.season.TvSeasonAppend
import dev.reuss.tmdb.domain.tv.series.TvSeriesAppend
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppendableResponseContractTest {

    @Test
    fun movieAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
            MovieAppend.entries,
            listOf(
                "alternative_titles",
                "changes",
                "credits",
                "external_ids",
                "images",
                "keywords",
                "recommendations",
                "release_dates",
                "reviews",
                "similar",
                "translations",
                "videos",
                "watch/providers"
            )
        )
    }

    @Test
    fun personAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
            PersonAppend.entries,
            listOf(
                "changes",
                "combined_credits",
                "external_ids",
                "images",
                "movie_credits",
                "tv_credits",
                "translations"
            )
        )
    }

    @Test
    fun tvSeriesAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
            TvSeriesAppend.entries,
            listOf(
                "aggregate_credits",
                "alternative_titles",
                "changes",
                "content_ratings",
                "credits",
                "episode_groups",
                "external_ids",
                "images",
                "keywords",
                "recommendations",
                "reviews",
                "screened_theatrically",
                "similar",
                "translations",
                "videos",
                "watch/providers"
            )
        )
    }

    @Test
    fun tvSeasonAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
            TvSeasonAppend.entries,
            listOf(
                "aggregate_credits",
                "changes",
                "credits",
                "external_ids",
                "images",
                "translations",
                "videos",
                "watch/providers"
            )
        )
    }

    @Test
    fun tvEpisodeAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
            TvEpisodeAppend.entries,
            listOf(
                "changes",
                "credits",
                "external_ids",
                "images",
                "translations",
                "videos"
            )
        )
    }

    @Test
    fun unusualWatchProvidersKeyRemainsStable() {
        assertEquals("watch/providers", MovieAppend.WATCH_PROVIDERS.value)
        assertEquals("watch/providers", TvSeriesAppend.WATCH_PROVIDERS.value)
        assertEquals("watch/providers", TvSeasonAppend.WATCH_PROVIDERS.value)
    }

    private fun assertAppendValues(
        values: Iterable<AppendableResponse>,
        expectedKeys: List<String>
    ) {
        values.forEach { value ->
            assertInstanceOf(AppendableResponse::class.java, value)
            assertNotNull(value.responseType)
        }

        assertEquals(
            expectedKeys,
            values.map { it.value }
        )
    }
}