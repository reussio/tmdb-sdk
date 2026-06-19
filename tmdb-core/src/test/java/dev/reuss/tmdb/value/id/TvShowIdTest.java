package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TvShowIdTest {

    @Test
    void createsTvShowId() {
        TvShowId id = TvShowId.of(1399);

        assertEquals(1399, id.value());
        assertEquals("1399", id.asString());
        assertEquals("1399", id.toString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TvShowId.of(0));

        assertEquals("TV series id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TvShowId.of(-1));

        assertEquals("TV series id must be greater than 0", exception.getMessage());
    }
}
