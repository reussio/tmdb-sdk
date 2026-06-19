package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TvNumberTest {

    @Test
    void tvSeasonNumberAllowsZeroForSpecials() {
        assertEquals(0, TvSeasonNumber.of(0).value());
        assertThrows(IllegalArgumentException.class, () -> TvSeasonNumber.of(-1));
    }

    @Test
    void tvEpisodeNumberMustBePositive() {
        assertEquals(1, TvEpisodeNumber.of(1).value());
        assertThrows(IllegalArgumentException.class, () -> TvEpisodeNumber.of(0));
    }
}
