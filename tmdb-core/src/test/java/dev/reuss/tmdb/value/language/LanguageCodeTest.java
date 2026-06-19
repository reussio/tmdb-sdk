package dev.reuss.tmdb.value.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LanguageCodeTest {

    @Test
    void createsLanguageCode() {
        LanguageCode code = LanguageCode.of("de");

        assertEquals("de", code.value());
        assertEquals("de", code.toString());
    }

    @Test
    void normalizesUppercaseLanguageCode() {
        LanguageCode code = LanguageCode.of("DE");

        assertEquals("de", code.value());
    }

    @Test
    void rejectsInvalidLanguageCodeFormat() {
        assertThrows(IllegalArgumentException.class, () -> LanguageCode.of(""));
        assertThrows(IllegalArgumentException.class, () -> LanguageCode.of("d"));
        assertThrows(IllegalArgumentException.class, () -> LanguageCode.of("deu"));
        assertThrows(IllegalArgumentException.class, () -> LanguageCode.of("1e"));
    }

    @Test
    void exposesCommonLanguageCodeConstants() {
        assertEquals("de", LanguageCodes.DE.value());
        assertEquals("en", LanguageCodes.EN.value());
        assertEquals("pt", LanguageCodes.PT.value());
    }
}
