package dev.reuss.tmdb.core.config

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.Duration

class TmdbClientConfigTest {
    @Test
    fun createsConfig() {
        val config =
            TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                Languages.DE_DE,
                Regions.DE,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10),
                TmdbMetricsRecorder.NOOP,
            )

        assertEquals("https://api.themoviedb.org/3", config.baseUrl)
        assertEquals(Languages.DE_DE, config.defaultLanguage)
        assertEquals(Regions.DE, config.defaultRegion)
        assertEquals(Duration.ofSeconds(5), config.connectTimeout)
        assertEquals(Duration.ofSeconds(10), config.requestTimeout)
    }

    @Test
    fun allowsNullDefaultRegion() {
        val config =
            TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                Languages.EN_US,
                null,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10),
                TmdbMetricsRecorder.NOOP,
            )

        assertNull(config.defaultRegion)
    }

    @Test
    fun rejectsBlankBaseUrl() {
        assertThrows<IllegalArgumentException> {
            TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10),
                TmdbMetricsRecorder.NOOP,
            )
        }

        assertThrows<IllegalArgumentException> {
            TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "   ",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10),
                TmdbMetricsRecorder.NOOP,
            )
        }
    }

    @Test
    fun rejectsBaseUrlThatCannotBeUsedForHttpRequests() {
        listOf(
            "not-a-url",
            "ftp://example.test/3",
            "https:///missing-host",
            "https://example.test/3?key=value",
            "https://example.test/3#fragment",
        ).forEach { invalidBaseUrl ->
            assertThrows<IllegalArgumentException> {
                config(baseUrl = invalidBaseUrl)
            }
        }
    }

    @Test
    fun trimsBaseUrl() {
        val config =
            TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "  https://api.themoviedb.org/3  ",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10),
                TmdbMetricsRecorder.NOOP,
            )

        assertEquals("https://api.themoviedb.org/3", config.baseUrl)
    }

    @Test
    fun rejectsZeroAndNegativeTimeouts() {
        listOf(Duration.ZERO, Duration.ofNanos(-1)).forEach { invalidTimeout ->
            assertThrows<IllegalArgumentException> {
                config(connectTimeout = invalidTimeout)
            }
            assertThrows<IllegalArgumentException> {
                config(requestTimeout = invalidTimeout)
            }
        }
    }

    private fun config(
        baseUrl: String = "https://api.themoviedb.org/3",
        connectTimeout: Duration = Duration.ofSeconds(5),
        requestTimeout: Duration = Duration.ofSeconds(10),
    ): TmdbClientConfig =
        TmdbClientConfig(
            TmdbAuth.bearerToken("token"),
            baseUrl,
            Languages.EN_US,
            Regions.US,
            connectTimeout,
            requestTimeout,
            TmdbMetricsRecorder.NOOP,
        )
}
