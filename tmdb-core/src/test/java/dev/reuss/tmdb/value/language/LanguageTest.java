package dev.reuss.tmdb.value.language;

import dev.reuss.tmdb.value.region.Regions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageTest {

    @Test
    void createsLanguageWithoutRegion() {
        Language language = Language.of("de");

        assertEquals("de", language.value());
        assertEquals("de", language.toString());
        assertTrue(language.regionOptional().isEmpty());
    }

    @Test
    void createsLanguageWithRegion() {
        Language language = Language.of("de-DE");

        assertEquals("de-DE", language.value());
        assertEquals("de-DE", language.toString());
        assertEquals("de", language.code().value());
        assertEquals("DE", language.region().value());
    }

    @Test
    void normalizesLanguageTag() {
        Language language = Language.of("DE-de");

        assertEquals("de-DE", language.value());
    }

    @Test
    void createsLanguageFromCodeAndRegion() {
        Language language = Language.of(LanguageCodes.DE, Regions.DE);

        assertEquals("de-DE", language.value());
    }

    @Test
    void rejectsInvalidLanguageTag() {
        assertThrows(IllegalArgumentException.class, () -> Language.of(""));
        assertThrows(IllegalArgumentException.class, () -> Language.of("deu-DE"));
        assertThrows(IllegalArgumentException.class, () -> Language.of("de-DEU"));
        assertThrows(IllegalArgumentException.class, () -> Language.of("de_DE"));
    }

    @Test
    void exposesCommonLanguageConstants() {
        assertEquals("de-DE", Languages.DE_DE.value());
        assertEquals("en-US", Languages.EN_US.value());
        assertEquals("pt-BR", Languages.PT_BR.value());
    }
}