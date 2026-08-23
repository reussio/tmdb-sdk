package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PersonIdTest {
    @Test
    fun createsPersonId() {
        val id = PersonId.of(287)

        assertEquals(287, id.value)
        assertEquals("287", id.asString())
        assertEquals("287", id.toString())
    }

    @Test
    fun rejectsZero() {
        val exception =
            assertThrows<IllegalArgumentException> {
                PersonId.of(0)
            }

        assertEquals("Person id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception =
            assertThrows<IllegalArgumentException> {
                PersonId.of(-1)
            }

        assertEquals("Person id must be greater than 0", exception.message)
    }
}
