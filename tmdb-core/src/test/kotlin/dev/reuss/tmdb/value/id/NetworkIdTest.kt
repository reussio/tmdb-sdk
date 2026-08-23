package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NetworkIdTest {

    @Test
    fun createsNetworkId() {
        val id = NetworkId.of(49)

        assertEquals(49, id.value)
        assertEquals("49", id.asString())
        assertEquals("49", id.toString())
    }

    @Test
    fun rejectsZero() {
        val exception = assertThrows<IllegalArgumentException> {
            NetworkId.of(0)
        }

        assertEquals("Network id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception = assertThrows<IllegalArgumentException> {
            NetworkId.of(-1)
        }

        assertEquals("Network id must be greater than 0", exception.message)
    }
}