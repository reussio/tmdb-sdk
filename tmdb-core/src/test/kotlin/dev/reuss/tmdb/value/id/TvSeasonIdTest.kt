package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TvSeasonIdTest {

    @Test
    fun createsTvSeasonId() {
        val id = TvSeasonId.of(3624)

        assertEquals(3624, id.value)
        assertEquals("3624", id.asString())
    }

    @Test
    fun rejectsZero() {
        val exception = assertThrows<IllegalArgumentException> {
            TvSeasonId.of(0)
        }

        assertEquals("TV season id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception = assertThrows<IllegalArgumentException> {
            TvSeasonId.of(-1)
        }

        assertEquals("TV season id must be greater than 0", exception.message)
    }
}