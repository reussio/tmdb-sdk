package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieIdTest {

    @Test
    void createsMovieId() {
        MovieId id = MovieId.of(550);

        assertEquals(550, id.value());
        assertEquals("550", id.asString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MovieId.of(0));

        assertEquals("Movie id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MovieId.of(-1));

        assertEquals("Movie id must be greater than 0", exception.getMessage());
    }
}
