package dev.reuss.tmdb.core.path

import dev.reuss.tmdb.value.id.MovieId
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TmdbPathTest {
    @Test
    fun tmdbPath_shouldNormalizeTextSegmentsAndSerializeResourceIds() {
        assertEquals(
            "/movie/550/videos",
            tmdbPath("/movie/", MovieId.of(550), "/videos/"),
        )
    }
}
