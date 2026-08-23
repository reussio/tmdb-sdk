package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MovieIdTest {
    @Test
    fun createsMovieId() {
        val id = MovieId.of(550)

        assertEquals(550, id.value)
        assertEquals("550", id.asString())
    }

    @Test
    fun rejectsZero() {
        val exception =
            assertThrows<IllegalArgumentException> {
                MovieId.of(0)
            }

        assertEquals("Movie id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception =
            assertThrows<IllegalArgumentException> {
                MovieId.of(-1)
            }

        assertEquals("Movie id must be greater than 0", exception.message)
    }
}
