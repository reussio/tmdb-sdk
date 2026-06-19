package dev.reuss.tmdb.value.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KeywordIdTest {

    @Test
    void createsKeywordId() {
        KeywordId id = KeywordId.of(9715);

        assertEquals(9715, id.value());
        assertEquals("9715", id.asString());
        assertEquals("9715", id.toString());
    }

    @Test
    void rejectsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> KeywordId.of(0));

        assertEquals("Keyword id must be greater than 0", exception.getMessage());
    }

    @Test
    void rejectsNegativeValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> KeywordId.of(-1));

        assertEquals("Keyword id must be greater than 0", exception.getMessage());
    }
}
