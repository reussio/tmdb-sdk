package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CompanyIdTest {

    @Test
    fun createsCompanyId() {
        val id = CompanyId.of(420)

        assertEquals(420, id.value)
        assertEquals("420", id.asString())
        assertEquals("420", id.toString())
    }

    @Test
    fun rejectsZero() {
        val exception = assertThrows<IllegalArgumentException> {
            CompanyId.of(0)
        }

        assertEquals("Company id must be greater than 0", exception.message)
    }

    @Test
    fun rejectsNegativeValue() {
        val exception = assertThrows<IllegalArgumentException> {
            CompanyId.of(-1)
        }

        assertEquals("Company id must be greater than 0", exception.message)
    }
}