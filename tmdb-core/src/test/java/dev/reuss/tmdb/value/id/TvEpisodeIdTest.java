package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TvEpisodeIdTest {

    @Test
    void createsTvEpisodeId() {
        TvEpisodeId id = TvEpisodeId.of(63056);

        assertEquals(63056, id.value());
        assertEquals("63056", id.asString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TvEpisodeId.of(0));

        assertEquals("TV episode id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TvEpisodeId.of(-1));

        assertEquals("TV episode id must be greater than 0", exception.getMessage());
    }
}
