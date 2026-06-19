package dev.reuss.tmdb.core.http;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QueryParamsTest {

    @Test
    void createsEmptyQueryParams() {
        Map<String, String> params = QueryParams.create().toMap();

        assertTrue(params.isEmpty());
    }

    @Test
    void addsStringValue() {
        Map<String, String> params = QueryParams.create()
                .add("language", "de-DE")
                .toMap();

        assertEquals("de-DE", params.get("language"));
    }

    @Test
    void addsObjectValue() {
        Map<String, String> params = QueryParams.create()
                .add("page", 2)
                .toMap();

        assertEquals("2", params.get("page"));
    }

    @Test
    void ignoresNullAndBlankValues() {
        Map<String, String> params = QueryParams.create()
                .add("language", (String) null)
                .add("region", "")
                .add("page", "1")
                .toMap();

        assertEquals(Map.of("page", "1"), params);
    }

    @Test
    void rejectsBlankParameterName() {
        assertThrows(IllegalArgumentException.class, () -> QueryParams.create().add("", "x"));
        assertThrows(IllegalArgumentException.class, () -> QueryParams.create().add("   ", "x"));
    }
}
