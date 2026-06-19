package dev.reuss.tmdb.core.http;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TmdbRequestTest {

    @Test
    void createsGetRequestWithoutParams() {
        TmdbRequest request = TmdbRequest.get("/configuration");

        assertEquals("/configuration", request.path());
        assertTrue(request.queryParams().isEmpty());
    }

    @Test
    void createsGetRequestWithParams() {
        TmdbRequest request = TmdbRequest.get(
                "/search/movie",
                QueryParams.create().add("query", "Fight Club")
        );

        assertEquals(Map.of("query", "Fight Club"), request.queryParams());
    }

    @Test
    void rejectsBlankPath() {
        assertThrows(IllegalArgumentException.class, () -> TmdbRequest.get(""));
        assertThrows(IllegalArgumentException.class, () -> TmdbRequest.get("   "));
    }

    @Test
    void rejectsPathWithoutLeadingSlash() {
        assertThrows(IllegalArgumentException.class, () -> TmdbRequest.get("configuration"));
    }
}