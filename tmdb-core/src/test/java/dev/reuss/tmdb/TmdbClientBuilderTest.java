package dev.reuss.tmdb;

import dev.reuss.tmdb.core.auth.TmdbAuth;
import dev.reuss.tmdb.value.language.Languages;
import dev.reuss.tmdb.value.region.Regions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TmdbClientBuilderTest {

    @Test
    void buildsTmdbClientWithAccessToken() {
        TmdbClient client = TmdbClient.builder()
                .accessToken("token")
                .build();

        assertNotNull(client);
    }

    @Test
    void buildsTmdbClientWithAuth() {
        TmdbClient client = TmdbClient.builder()
                .auth(TmdbAuth.bearerToken("token"))
                .build();

        assertNotNull(client);
    }

    @Test
    void buildsTmdbClientWithCustomDefaults() {
        TmdbClient client = TmdbClient.builder()
                .accessToken("token")
                .baseUrl("https://example.com/3")
                .defaultLanguage(Languages.DE_DE)
                .defaultRegion(Regions.DE)
                .connectTimeout(Duration.ofSeconds(1))
                .requestTimeout(Duration.ofSeconds(2))
                .build();

        assertNotNull(client);
    }

    @Test
    void rejectsMissingAuthOnBuild() {
        assertThrows(NullPointerException.class, () -> TmdbClient.builder().build());
    }

    @Test
    void rejectsBlankAccessToken() {
        assertThrows(IllegalArgumentException.class, () -> TmdbClient.builder().accessToken(""));
        assertThrows(IllegalArgumentException.class, () -> TmdbClient.builder().accessToken("   "));
    }
}