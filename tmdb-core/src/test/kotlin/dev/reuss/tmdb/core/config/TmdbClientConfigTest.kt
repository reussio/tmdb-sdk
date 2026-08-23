package dev.reuss.tmdb.core.config

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.InvocationTargetException
import java.time.Duration

class TmdbClientConfigTest {

    @Test
    fun createsConfig() {
        val config = TmdbClientConfig(
            TmdbAuth.bearerToken("token"),
            "https://api.themoviedb.org/3",
            Languages.DE_DE,
            Regions.DE,
            Duration.ofSeconds(5),
            Duration.ofSeconds(10),
            TmdbMetricsRecorder.NOOP
        )

        assertEquals("https://api.themoviedb.org/3", config.baseUrl)
        assertEquals(Languages.DE_DE, config.defaultLanguage)
        assertEquals(Regions.DE, config.defaultRegion)
        assertEquals(Duration.ofSeconds(5), config.connectTimeout)
        assertEquals(Duration.ofSeconds(10), config.requestTimeout)
    }

    @Test
    fun allowsNullDefaultRegion() {
        val config = TmdbClientConfig(
            TmdbAuth.bearerToken("token"),
            "https://api.themoviedb.org/3",
            Languages.EN_US,
            null,
            Duration.ofSeconds(5),
            Duration.ofSeconds(10),
            TmdbMetricsRecorder.NOOP
        )

        assertNull(config.defaultRegion)
    }

    @Test
    fun rejectsNullAuth() {
        assertConstructorRejectsNull(
            null,
            "https://api.themoviedb.org/3",
            Languages.EN_US,
            Regions.US,
            Duration.ofSeconds(5),
            Duration.ofSeconds(10),
            TmdbMetricsRecorder.NOOP
        )
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
                TmdbMetricsRecorder.NOOP
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
                TmdbMetricsRecorder.NOOP
            )
        }
    }

    @Test
    fun trimsBaseUrl() {
        val config = TmdbClientConfig(
            TmdbAuth.bearerToken("token"),
            "  https://api.themoviedb.org/3  ",
            Languages.EN_US,
            Regions.US,
            Duration.ofSeconds(5),
            Duration.ofSeconds(10),
            TmdbMetricsRecorder.NOOP
        )

        assertEquals("https://api.themoviedb.org/3", config.baseUrl)
    }

    @Test
    fun rejectsNullDefaultLanguage() {
        assertConstructorRejectsNull(
            TmdbAuth.bearerToken("token"),
            "https://api.themoviedb.org/3",
            null,
            Regions.US,
            Duration.ofSeconds(5),
            Duration.ofSeconds(10),
            TmdbMetricsRecorder.NOOP
        )
    }

    @Test
    fun rejectsNullTimeouts() {
        assertConstructorRejectsNull(
            TmdbAuth.bearerToken("token"),
            "https://api.themoviedb.org/3",
            Languages.EN_US,
            Regions.US,
            null,
            Duration.ofSeconds(10),
            TmdbMetricsRecorder.NOOP
        )

        assertConstructorRejectsNull(
            TmdbAuth.bearerToken("token"),
            "https://api.themoviedb.org/3",
            Languages.EN_US,
            Regions.US,
            Duration.ofSeconds(5),
            null,
            TmdbMetricsRecorder.NOOP
        )
    }

    private fun assertConstructorRejectsNull(vararg arguments: Any?) {
        val constructor = TmdbClientConfig::class.java.declaredConstructors
            .first { it.parameterCount == 7 && !it.isSynthetic }

        val exception = assertThrows<InvocationTargetException> {
            constructor.newInstance(*arguments)
        }

        assertInstanceOf(
            NullPointerException::class.java,
            exception.cause
        )
    }
}