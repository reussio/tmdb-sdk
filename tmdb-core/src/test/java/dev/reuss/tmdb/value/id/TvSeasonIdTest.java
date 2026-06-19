package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TvSeasonIdTest {

    @Test
    void createsTvSeasonId() {
        TvSeasonId id = TvSeasonId.of(3624);

        assertEquals(3624, id.value());
        assertEquals("3624", id.asString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TvSeasonId.of(0));

        assertEquals("TV season id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TvSeasonId.of(-1));

        assertEquals("TV season id must be greater than 0", exception.getMessage());
    }
}
