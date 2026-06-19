package dev.reuss.tmdb.core.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TmdbAuthTest {

    @Test
    void bearerTokenCreatesAuthorizationHeader() {
        TmdbAuth auth = TmdbAuth.bearerToken("abc123");

        assertEquals("Bearer abc123", auth.authorizationHeaderValue());
    }

    @Test
    void trimsAccessToken() {
        TmdbAuth auth = TmdbAuth.bearerToken("  abc123  ");

        assertEquals("Bearer abc123", auth.authorizationHeaderValue());
    }

    @Test
    void rejectsBlankAccessToken() {
        assertThrows(IllegalArgumentException.class, () -> TmdbAuth.bearerToken(""));
        assertThrows(IllegalArgumentException.class, () -> TmdbAuth.bearerToken("   "));
    }

    @Test
    void rejectsNullAccessToken() {
        assertThrows(IllegalArgumentException.class, () -> TmdbAuth.bearerToken(null));
    }

    @Test
    void doesNotExposeTokenInToString() {
        TmdbAuth auth = TmdbAuth.bearerToken("secret-token");

        assertFalse(auth.toString().contains("secret-token"));
    }
}
