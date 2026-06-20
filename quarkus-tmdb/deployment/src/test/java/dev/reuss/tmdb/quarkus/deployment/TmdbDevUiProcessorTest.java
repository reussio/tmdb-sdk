package dev.reuss.tmdb.quarkus.deployment;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbDevUiProcessorTest {

    @Test
    void shouldExposeMaskedConfigurationRows() {
        List<Map<String, String>> rows = TmdbDevUiProcessor.devUiConfigurationRows(
                "0.2.0",
                "https://example.test/3",
                "de-DE",
                "DE",
                "3s",
                "12s",
                true);

        assertEquals("Extension Version", rows.get(0).get("name"));
        assertEquals("0.2.0", rows.get(0).get("value"));
        assertEquals("Base URL", rows.get(1).get("name"));
        assertEquals("https://example.test/3", rows.get(1).get("value"));
        assertEquals("Default Language", rows.get(2).get("name"));
        assertEquals("de-DE", rows.get(2).get("value"));
        assertEquals("Default Region", rows.get(3).get("name"));
        assertEquals("DE", rows.get(3).get("value"));
        assertEquals("Connect Timeout", rows.get(4).get("name"));
        assertEquals("3s", rows.get(4).get("value"));
        assertEquals("Request Timeout", rows.get(5).get("name"));
        assertEquals("12s", rows.get(5).get("value"));
        assertEquals("Access Token", rows.get(6).get("name"));
        assertEquals("configured", rows.get(6).get("value"));
    }

    @Test
    void shouldNotExposeMissingTokenValue() {
        List<Map<String, String>> rows = TmdbDevUiProcessor.devUiConfigurationRows(
                "0.2.0",
                "https://example.test/3",
                "de-DE",
                "DE",
                "3s",
                "12s",
                false);

        assertEquals("not configured", rows.get(6).get("value"));
    }

    @Test
    void shouldExposeStatusRows() {
        List<Map<String, String>> rows = TmdbDevUiProcessor.devUiStatusRows(
                true,
                "https://example.test/3",
                true,
                false,
                42);

        assertEquals("Configuration", rows.get(0).get("name"));
        assertEquals("ready", rows.get(0).get("status"));
        assertEquals("Access Token", rows.get(1).get("name"));
        assertEquals("configured", rows.get(1).get("status"));
        assertEquals("Base URL", rows.get(2).get("name"));
        assertEquals("valid", rows.get(2).get("status"));
        assertEquals("Health Capability", rows.get(3).get("name"));
        assertEquals("active", rows.get(3).get("status"));
        assertEquals("Metrics Capability", rows.get(4).get("name"));
        assertEquals("inactive", rows.get(4).get("status"));
        assertEquals("Native Reflection", rows.get(5).get("name"));
        assertEquals("registered", rows.get(5).get("status"));
        assertEquals("42 SDK model classes", rows.get(5).get("details"));
    }

    @Test
    void shouldMarkConfigurationIncompleteForMissingTokenOrInvalidBaseUrl() {
        List<Map<String, String>> missingTokenRows = TmdbDevUiProcessor.devUiStatusRows(
                false,
                "https://example.test/3",
                false,
                false,
                42);
        List<Map<String, String>> invalidBaseUrlRows = TmdbDevUiProcessor.devUiStatusRows(
                true,
                "not a uri",
                false,
                false,
                42);

        assertEquals("incomplete", missingTokenRows.get(0).get("status"));
        assertEquals("incomplete", invalidBaseUrlRows.get(0).get("status"));
        assertEquals("invalid", invalidBaseUrlRows.get(2).get("status"));
    }

    @Test
    void shouldExposeCdiServiceRows() {
        List<Map<String, String>> rows = TmdbDevUiProcessor.devUiServiceRows();

        assertTrue(rows.stream().anyMatch(row -> "TmdbClient".equals(row.get("name"))
                && "dev.reuss.tmdb.TmdbClient".equals(row.get("type"))));
        assertTrue(rows.stream().anyMatch(row -> "MovieService".equals(row.get("name"))
                && "dev.reuss.tmdb.domain.movie.MovieService".equals(row.get("type"))));
        assertTrue(rows.stream().anyMatch(row -> "TvSeriesService".equals(row.get("name"))
                && "dev.reuss.tmdb.domain.tv.series.TvSeriesService".equals(row.get("type"))));
        assertFalse(rows.stream().anyMatch(row -> "TmdbMetricsRecorder".equals(row.get("name"))));
        assertEquals(22, rows.size());
    }
}
