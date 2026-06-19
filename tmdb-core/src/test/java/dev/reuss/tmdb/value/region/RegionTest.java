package dev.reuss.tmdb.value.region;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegionTest {

    @Test
    void createsRegionFromUppercaseCode() {
        Region region = Region.of("DE");

        assertEquals("DE", region.value());
        assertEquals("DE", region.toString());
    }

    @Test
    void normalizesLowercaseCode() {
        Region region = Region.of("de");

        assertEquals("DE", region.value());
    }

    @Test
    void rejectsInvalidRegionFormat() {
        assertThrows(IllegalArgumentException.class, () -> Region.of(""));
        assertThrows(IllegalArgumentException.class, () -> Region.of("D"));
        assertThrows(IllegalArgumentException.class, () -> Region.of("GER"));
        assertThrows(IllegalArgumentException.class, () -> Region.of("1E"));
    }

    @Test
    void exposesCommonRegionConstants() {
        assertEquals("DE", Regions.DE.value());
        assertEquals("US", Regions.US.value());
        assertEquals("GB", Regions.GB.value());
    }
}