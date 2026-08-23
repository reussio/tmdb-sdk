package dev.reuss.tmdb

import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.Duration

class TmdbClientBuilderTest {

    @Test
    fun buildsTmdbClientWithAccessToken() {
        val client = TmdbClient.builder()
            .accessToken("token")
            .build()

        assertNotNull(client)
    }

    @Test
    fun buildsTmdbClientWithAuth() {
        val client = TmdbClient.builder()
            .auth(TmdbAuth.bearerToken("token"))
            .build()

        assertNotNull(client)
    }

    @Test
    fun buildsTmdbClientWithCustomDefaults() {
        val client = TmdbClient.builder()
            .accessToken("token")
            .baseUrl("https://example.com/3")
            .defaultLanguage(Languages.DE_DE)
            .defaultRegion(Regions.DE)
            .connectTimeout(Duration.ofSeconds(1))
            .requestTimeout(Duration.ofSeconds(2))
            .build()

        assertNotNull(client)
    }

    @Test
    fun rejectsMissingAuthOnBuild() {
        assertThrows<IllegalArgumentException> {
            TmdbClient.builder().build()
        }
    }

    @Test
    fun rejectsBlankAccessToken() {
        assertThrows<IllegalArgumentException> {
            TmdbClient.builder().accessToken("")
        }

        assertThrows<IllegalArgumentException> {
            TmdbClient.builder().accessToken("   ")
        }
    }
}