package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TvShowIdTest {

    @Test
    fun createsTvShowId() {
        val id = TvShowId.of(1399)

        assertEquals(1399, id.value)
        assertEquals("1399", id.asString())
        assertEquals("1399", id.toString())
    }

    @Test
    fun rejectsZero() {
        val exception = assertThrows<IllegalArgumentException> {
            TvShowId.of(0)
        }

        assertEquals("TV series id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception = assertThrows<IllegalArgumentException> {
            TvShowId.of(-1)
        }

        assertEquals("TV series id must be greater than 0", exception.message)
    }
}