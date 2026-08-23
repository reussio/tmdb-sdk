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
        val params =
            QueryParams
                .create()
                .add("language", "de-DE")
                .toMap()

        assertEquals("de-DE", params["language"])
    }

    @Test
    fun addsObjectValue() {
        val params =
            QueryParams
                .create()
                .add("page", 2)
                .toMap()

        assertEquals("2", params["page"])
    }

    @Test
    fun ignoresNullAndBlankValues() {
        val params =
            QueryParams
                .create()
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

    @Test
    fun toMap_returnsImmutableSnapshot() {
        val builder =
            QueryParams
                .create()
                .add("page", 1)
                .add("language", "de-DE")
        val snapshot = builder.toMap()

        builder.add("region", "DE")

        assertEquals(mapOf("page" to "1", "language" to "de-DE"), snapshot)
        assertThrows<UnsupportedOperationException> {
            (snapshot as MutableMap<String, String>)["region"] = "US"
        }
    }

    @Test
    fun add_shouldReplaceAnExistingParameterWithoutChangingItsPosition() {
        val params =
            QueryParams
                .create()
                .add("language", "en-US")
                .add("page", 2)
                .add("language", "de-DE")
                .toMap()

        assertEquals(
            listOf("language" to "de-DE", "page" to "2"),
            params.entries.map { it.key to it.value },
        )
    }
}
