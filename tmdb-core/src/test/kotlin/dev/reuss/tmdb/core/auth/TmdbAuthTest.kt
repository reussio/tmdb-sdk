package dev.reuss.tmdb.core.auth

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TmdbAuthTest {
    @Test
    fun bearerTokenCreatesAuthorizationHeader() {
        val auth = TmdbAuth.bearerToken("abc123")

        assertEquals("Bearer abc123", auth.authorizationHeaderValue())
    }

    @Test
    fun trimsAccessToken() {
        val auth = TmdbAuth.bearerToken("  abc123  ")

        assertEquals("Bearer abc123", auth.authorizationHeaderValue())
    }

    @Test
    fun rejectsBlankAccessToken() {
        assertThrows<IllegalArgumentException> {
            TmdbAuth.bearerToken("")
        }

        assertThrows<IllegalArgumentException> {
            TmdbAuth.bearerToken("   ")
        }
    }

    @Test
    fun doesNotExposeTokenInToString() {
        val auth = TmdbAuth.bearerToken("secret-token")

        assertFalse(auth.toString().contains("secret-token"))
    }

    @Test
    fun equality_shouldUseTheNormalizedTokenValue() {
        val auth = TmdbAuth.bearerToken(" token ")
        val equalAuth = TmdbAuth.bearerToken("token")

        assertEquals(equalAuth, auth)
        assertEquals(equalAuth.hashCode(), auth.hashCode())
        assertNotEquals(TmdbAuth.bearerToken("other"), auth)
    }
}
