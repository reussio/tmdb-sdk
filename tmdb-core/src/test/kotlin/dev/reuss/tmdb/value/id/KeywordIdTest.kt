package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class KeywordIdTest {

    @Test
    fun createsKeywordId() {
        val id = KeywordId.of(9715)

        assertEquals(9715, id.value)
        assertEquals("9715", id.asString())
        assertEquals("9715", id.toString())
    }

    @Test
    fun rejectsZero() {
        val exception = assertThrows<IllegalArgumentException> {
            KeywordId.of(0)
        }

        assertEquals("Keyword id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception = assertThrows<IllegalArgumentException> {
            KeywordId.of(-1)
        }

        assertEquals("Keyword id must be greater than 0", exception.message)
    }
}