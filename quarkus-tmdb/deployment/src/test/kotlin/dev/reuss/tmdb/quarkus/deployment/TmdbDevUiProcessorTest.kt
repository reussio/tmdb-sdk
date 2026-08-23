package dev.reuss.tmdb.quarkus.deployment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TmdbDevUiProcessorTest {

    @Test
    fun shouldExposeMaskedConfigurationRows() {
        val rows = TmdbDevUiProcessor.devUiConfigurationRows(
            "0.2.0",
            "https://example.test/3",
            "de-DE",
            "DE",
            "3s",
            "12s",
            true
        )

        assertEquals("Extension Version", rows[0]["name"])
        assertEquals("0.2.0", rows[0]["value"])
        assertEquals("Base URL", rows[1]["name"])
        assertEquals("https://example.test/3", rows[1]["value"])
        assertEquals("Default Language", rows[2]["name"])
        assertEquals("de-DE", rows[2]["value"])
        assertEquals("Default Region", rows[3]["name"])
        assertEquals("DE", rows[3]["value"])
        assertEquals("Connect Timeout", rows[4]["name"])
        assertEquals("3s", rows[4]["value"])
        assertEquals("Request Timeout", rows[5]["name"])
        assertEquals("12s", rows[5]["value"])
        assertEquals("Access Token", rows[6]["name"])
        assertEquals("configured", rows[6]["value"])
    }

    @Test
    fun shouldNotExposeMissingTokenValue() {
        val rows = TmdbDevUiProcessor.devUiConfigurationRows(
            "0.2.0",
            "https://example.test/3",
            "de-DE",
            "DE",
            "3s",
            "12s",
            false
        )

        assertEquals("not configured", rows[6]["value"])
    }

    @Test
    fun shouldExposeStatusRows() {
        val rows = TmdbDevUiProcessor.devUiStatusRows(
            true,
            "https://example.test/3",
            true,
            false,
            42
        )

        assertEquals("Configuration", rows[0]["name"])
        assertEquals("ready", rows[0]["status"])
        assertEquals("Access Token", rows[1]["name"])
        assertEquals("configured", rows[1]["status"])
        assertEquals("Base URL", rows[2]["name"])
        assertEquals("valid", rows[2]["status"])
        assertEquals("Health Capability", rows[3]["name"])
        assertEquals("active", rows[3]["status"])
        assertEquals("Metrics Capability", rows[4]["name"])
        assertEquals("inactive", rows[4]["status"])
        assertEquals("Native Reflection", rows[5]["name"])
        assertEquals("registered", rows[5]["status"])
        assertEquals("42 SDK model classes", rows[5]["details"])
    }

    @Test
    fun shouldMarkConfigurationIncompleteForMissingTokenOrInvalidBaseUrl() {
        val missingTokenRows = TmdbDevUiProcessor.devUiStatusRows(
            false,
            "https://example.test/3",
            false,
            false,
            42
        )

        val invalidBaseUrlRows = TmdbDevUiProcessor.devUiStatusRows(
            true,
            "not a uri",
            false,
            false,
            42
        )

        assertEquals("incomplete", missingTokenRows[0]["status"])
        assertEquals("incomplete", invalidBaseUrlRows[0]["status"])
        assertEquals("invalid", invalidBaseUrlRows[2]["status"])
    }

    @Test
    fun shouldExposeCdiServiceRows() {
        val rows = TmdbDevUiProcessor.devUiServiceRows()

        assertTrue(
            rows.any { row ->
                row["name"] == "TmdbClient" &&
                    row["type"] == "dev.reuss.tmdb.TmdbClient"
            }
        )

        assertTrue(
            rows.any { row ->
                row["name"] == "MovieService" &&
                    row["type"] == "dev.reuss.tmdb.domain.movie.MovieService"
            }
        )

        assertTrue(
            rows.any { row ->
                row["name"] == "TvSeriesService" &&
                    row["type"] == "dev.reuss.tmdb.domain.tv.series.TvSeriesService"
            }
        )

        assertFalse(
            rows.any { row ->
                row["name"] == "TmdbMetricsRecorder"
            }
        )

        assertEquals(22, rows.size)
    }
}