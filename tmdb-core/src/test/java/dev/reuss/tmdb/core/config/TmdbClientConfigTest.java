package dev.reuss.tmdb.core.config;

import dev.reuss.tmdb.core.auth.TmdbAuth;
import dev.reuss.tmdb.value.language.Languages;
import dev.reuss.tmdb.value.region.Regions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TmdbClientConfigTest {

    @Test
    void createsConfig() {
        TmdbClientConfig config = new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                Languages.DE_DE,
                Regions.DE,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        );

        assertEquals("https://api.themoviedb.org/3", config.baseUrl());
        assertEquals(Languages.DE_DE, config.defaultLanguage());
        assertEquals(Regions.DE, config.defaultRegion());
        assertEquals(Duration.ofSeconds(5), config.connectTimeout());
        assertEquals(Duration.ofSeconds(10), config.requestTimeout());
    }

    @Test
    void allowsNullDefaultRegion() {
        TmdbClientConfig config = new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                Languages.EN_US,
                null,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        );

        assertNull(config.defaultRegion());
    }

    @Test
    void rejectsNullAuth() {
        assertThrows(NullPointerException.class, () -> new TmdbClientConfig(
                null,
                "https://api.themoviedb.org/3",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        ));
    }

    @Test
    void rejectsBlankBaseUrl() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        ));

        assertThrows(IllegalArgumentException.class, () -> new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "   ",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        ));
    }

    @Test
    void trimsBaseUrl() {
        TmdbClientConfig config = new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "  https://api.themoviedb.org/3  ",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        );

        assertEquals("https://api.themoviedb.org/3", config.baseUrl());
    }

    @Test
    void rejectsNullDefaultLanguage() {
        assertThrows(NullPointerException.class, () -> new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                null,
                Regions.US,
                Duration.ofSeconds(5),
                Duration.ofSeconds(10)
        ));
    }

    @Test
    void rejectsNullTimeouts() {
        assertThrows(NullPointerException.class, () -> new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                Languages.EN_US,
                Regions.US,
                null,
                Duration.ofSeconds(10)
        ));

        assertThrows(NullPointerException.class, () -> new TmdbClientConfig(
                TmdbAuth.bearerToken("token"),
                "https://api.themoviedb.org/3",
                Languages.EN_US,
                Regions.US,
                Duration.ofSeconds(5),
                null
        ));
    }
}
