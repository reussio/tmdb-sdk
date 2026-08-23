package dev.reuss.tmdb.core.auth

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.InvocationTargetException

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
    fun rejectsNullAccessToken() {
        val exception =
            assertThrows<InvocationTargetException> {
                TmdbAuth::class.java
                    .getMethod("bearerToken", String::class.java)
                    .invoke(null, null)
            }

        assertInstanceOf(
            NullPointerException::class.java,
            exception.cause,
        )
    }

    @Test
    fun doesNotExposeTokenInToString() {
        val auth = TmdbAuth.bearerToken("secret-token")

        assertFalse(auth.toString().contains("secret-token"))
    }
}
