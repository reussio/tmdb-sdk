package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonIdTest {

    @Test
    void createsPersonId() {
        PersonId id = PersonId.of(287);

        assertEquals(287, id.value());
        assertEquals("287", id.asString());
        assertEquals("287", id.toString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PersonId.of(0));

        assertEquals("Person id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PersonId.of(-1));

        assertEquals("Person id must be greater than 0", exception.getMessage());
    }
}
