package dev.reuss.tmdb.value.language

import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LanguageTest {
    @Test
    fun createsLanguageWithoutRegion() {
        val language = Language.of("de")

        assertEquals("de", language.value)
        assertEquals("de", language.toString())
        assertNull(language.region)
    }

    @Test
    fun createsLanguageWithRegion() {
        val language = Language.of("de-DE")

        assertEquals("de-DE", language.value)
        assertEquals("de-DE", language.toString())
        assertEquals("de", language.code.value)
        assertEquals("DE", language.region?.value)
    }

    @Test
    fun normalizesLanguageTag() {
        val language = Language.of("  DE-de  ")

        assertEquals("de-DE", language.value)
        assertEquals(Regions.DE, language.regionOptional().orElseThrow())
    }

    @Test
    fun createsLanguageFromCodeAndRegion() {
        val language = Language.of(LanguageCodes.DE, Regions.DE)

        assertEquals("de-DE", language.value)
    }

    @Test
    fun rejectsInvalidLanguageTag() {
        assertThrows<IllegalArgumentException> {
            Language.of("")
        }

        assertThrows<IllegalArgumentException> {
            Language.of("deu-DE")
        }

        assertThrows<IllegalArgumentException> {
            Language.of("de-DEU")
        }

        assertThrows<IllegalArgumentException> {
            Language.of("de_DE")
        }

        assertThrows<IllegalArgumentException> {
            Language.of("zz-US")
        }

        assertTrue(Language.of("de").regionOptional().isEmpty)
    }

    @Test
    fun exposesCommonLanguageConstants() {
        assertEquals("de-DE", Languages.DE_DE.value)
        assertEquals("en-US", Languages.EN_US.value)
        assertEquals("pt-BR", Languages.PT_BR.value)
    }
}
