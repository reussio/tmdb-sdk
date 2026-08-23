package dev.reuss.tmdb.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class QueryParamsTest {

    @Test
    fun createsEmptyQueryParams() {
        val params = QueryParams.create().toMap()

        assertTrue(params.isEmpty())
    }

    @Test
    fun addsStringValue() {
        val params = QueryParams.create()
            .add("language", "de-DE")
            .toMap()

        assertEquals("de-DE", params["language"])
    }

    @Test
    fun addsObjectValue() {
        val params = QueryParams.create()
            .add("page", 2)
            .toMap()

        assertEquals("2", params["page"])
    }

    @Test
    fun ignoresNullAndBlankValues() {
        val params = QueryParams.create()
            .add("language", null as String?)
            .add("region", "")
            .add("page", "1")
            .toMap()

        assertEquals(mapOf("page" to "1"), params)
    }

    @Test
    fun rejectsBlankParameterName() {
        assertThrows<IllegalArgumentException> {
            QueryParams.create().add("", "x")
        }

        assertThrows<IllegalArgumentException> {
            QueryParams.create().add("   ", "x")
        }
    }
}