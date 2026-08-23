package dev.reuss.tmdb.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
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

    @Test
    fun get_shouldDefensivelyCopyQueryParameters() {
        val queryParams = QueryParams.create().add("page", 1)
        val request = TmdbRequest.get("/movie/popular", queryParams)

        queryParams.add("language", "de-DE")

        assertEquals(mapOf("page" to "1"), request.queryParams)
        assertThrows<UnsupportedOperationException> {
            (request.queryParams as MutableMap<String, String>)["region"] = "DE"
        }
    }

    @Test
    fun equality_shouldUsePathAndQueryParameters() {
        val request =
            TmdbRequest.get(
                "/movie/popular",
                QueryParams.create().add("page", 2),
            )
        val equalRequest =
            TmdbRequest.get(
                "/movie/popular",
                QueryParams.create().add("page", 2),
            )

        assertEquals(equalRequest, request)
        assertEquals(equalRequest.hashCode(), request.hashCode())
        assertNotEquals(TmdbRequest.get("/movie/top_rated"), request)
    }
}
