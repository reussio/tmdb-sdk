package dev.reuss.tmdb.value.language

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LanguageCodeTest {

    @Test
    fun createsLanguageCode() {
        val code = LanguageCode.of("de")

        assertEquals("de", code.value)
        assertEquals("de", code.toString())
    }

    @Test
    fun normalizesUppercaseLanguageCode() {
        val code = LanguageCode.of("DE")

        assertEquals("de", code.value)
    }

    @Test
    fun rejectsInvalidLanguageCodeFormat() {
        assertThrows<IllegalArgumentException> {
            LanguageCode.of("")
        }

        assertThrows<IllegalArgumentException> {
            LanguageCode.of("d")
        }

        assertThrows<IllegalArgumentException> {
            LanguageCode.of("deu")
        }

        assertThrows<IllegalArgumentException> {
            LanguageCode.of("1e")
        }
    }

    @Test
    fun exposesCommonLanguageCodeConstants() {
        assertEquals("de", LanguageCodes.DE.value)
        assertEquals("en", LanguageCodes.EN.value)
        assertEquals("pt", LanguageCodes.PT.value)
    }
}