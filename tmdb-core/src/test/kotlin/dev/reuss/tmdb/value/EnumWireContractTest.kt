package dev.reuss.tmdb.value

import dev.reuss.tmdb.domain.find.model.ExternalSource
import dev.reuss.tmdb.domain.movie.model.MovieReleaseType
import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupType
import dev.reuss.tmdb.value.media.MediaType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EnumWireContractTest {
    @Test
    fun fromValue_shouldMapMovieReleaseTypeAndRejectUnknownValue() {
        MovieReleaseType.entries.forEach { releaseType ->
            assertEquals(releaseType, MovieReleaseType.fromValue(releaseType.value))
        }

        assertThrows<IllegalArgumentException> {
            MovieReleaseType.fromValue(0)
        }
    }

    @Test
    fun fromValue_shouldMapEpisodeGroupTypeAndRejectUnknownValue() {
        TvEpisodeGroupType.entries.forEach { groupType ->
            assertEquals(groupType, TvEpisodeGroupType.fromValue(groupType.value))
        }

        assertThrows<IllegalArgumentException> {
            TvEpisodeGroupType.fromValue(0)
        }
    }

    @Test
    fun fromValue_shouldFallbackToUnknown_whenMediaTypeIsMissingOrUnsupported() {
        assertEquals(MediaType.MOVIE, MediaType.fromValue("movie"))
        assertEquals(MediaType.TV, MediaType.fromValue("tv"))
        assertEquals(MediaType.PERSON, MediaType.fromValue("person"))
        assertEquals(MediaType.UNKNOWN, MediaType.fromValue("collection"))
        assertEquals(MediaType.UNKNOWN, MediaType.fromValue(null))
    }

    @Test
    fun externalSources_shouldExposeStableTmdbQueryValues() {
        assertEquals(
            listOf(
                "imdb_id",
                "facebook_id",
                "instagram_id",
                "tvdb_id",
                "tiktok_id",
                "twitter_id",
                "wikidata_id",
                "youtube_id",
            ),
            ExternalSource.entries.map { it.value },
        )
    }
}
