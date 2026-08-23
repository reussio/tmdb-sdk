package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TvEpisodeIdTest {

    @Test
    fun createsTvEpisodeId() {
        val id = TvEpisodeId.of(63056)

        assertEquals(63056, id.value)
        assertEquals("63056", id.asString())
    }

    @Test
    fun rejectsZero() {
        val exception = assertThrows<IllegalArgumentException> {
            TvEpisodeId.of(0)
        }

        assertEquals("TV episode id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception = assertThrows<IllegalArgumentException> {
            TvEpisodeId.of(-1)
        }

        assertEquals("TV episode id must be greater than 0", exception.message)
    }
}