package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompanyIdTest {

    @Test
    void createsCompanyId() {
        CompanyId id = CompanyId.of(420);

        assertEquals(420, id.value());
        assertEquals("420", id.asString());
        assertEquals("420", id.toString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> CompanyId.of(0));

        assertEquals("Company id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> CompanyId.of(-1));

        assertEquals("Company id must be greater than 0", exception.getMessage());
    }
}
