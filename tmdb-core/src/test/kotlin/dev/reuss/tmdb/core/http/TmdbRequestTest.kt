package dev.reuss.tmdb.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TmdbRequestTest {
    @Test
    fun createsGetRequestWithoutParams() {
        val request = TmdbRequest.get("/configuration")

        assertEquals("/configuration", request.path)
        assertTrue(request.queryParams.isEmpty())
    }

    @Test
    fun createsGetRequestWithParams() {
        val request =
            TmdbRequest.get(
                "/search/movie",
                QueryParams
                    .create()
                    .add("query", "Fight Club"),
            )

        assertEquals(
            mapOf("query" to "Fight Club"),
            request.queryParams,
        )
    }

    @Test
    fun rejectsBlankPath() {
        assertThrows<IllegalArgumentException> {
            TmdbRequest.get("")
        }

        assertThrows<IllegalArgumentException> {
            TmdbRequest.get("   ")
        }
    }

    @Test
    fun rejectsPathWithoutLeadingSlash() {
        assertThrows<IllegalArgumentException> {
            TmdbRequest.get("configuration")
        }
    }
}
