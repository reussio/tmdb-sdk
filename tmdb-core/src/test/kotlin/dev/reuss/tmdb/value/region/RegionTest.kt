package dev.reuss.tmdb.value.region

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RegionTest {
    @Test
    fun createsRegionFromUppercaseCode() {
        val region = Region.of("DE")

        assertEquals("DE", region.value)
        assertEquals("DE", region.toString())
    }

    @Test
    fun normalizesLowercaseCode() {
        val region = Region.of("de")

        assertEquals("DE", region.value)
    }

    @Test
    fun rejectsInvalidRegionFormat() {
        assertThrows<IllegalArgumentException> {
            Region.of("")
        }

        assertThrows<IllegalArgumentException> {
            Region.of("D")
        }

        assertThrows<IllegalArgumentException> {
            Region.of("GER")
        }

        assertThrows<IllegalArgumentException> {
            Region.of("1E")
        }

        assertThrows<IllegalArgumentException> {
            Region.of("ZZ")
        }
    }

    @Test
    fun exposesCommonRegionConstants() {
        assertEquals("DE", Regions.DE.value)
        assertEquals("US", Regions.US.value)
        assertEquals("GB", Regions.GB.value)
    }
}
