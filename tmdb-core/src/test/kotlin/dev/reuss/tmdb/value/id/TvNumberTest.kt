package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TvNumberTest {
    @Test
    fun tvSeasonNumberAllowsZeroForSpecials() {
        assertEquals(0, TvSeasonNumber.of(0).value)

        assertThrows<IllegalArgumentException> {
            TvSeasonNumber.of(-1)
        }
    }

    @Test
    fun tvEpisodeNumberMustBePositive() {
        assertEquals(1, TvEpisodeNumber.of(1).value)

        assertThrows<IllegalArgumentException> {
            TvEpisodeNumber.of(0)
        }
    }
}
