package dev.reuss.tmdb.core.auth;

import java.io.Serializable;

/**
 * Represents TMDB API authentication.
 *
 * <p>TMDB API requests are authenticated with a bearer access token.
 * This value object stores the raw access token and can create the
 * corresponding HTTP {@code Authorization} header value.</p>
 *
 * <p>The access token is intentionally masked in {@link #toString()} to
 * avoid accidentally exposing credentials in logs or debug output.</p>
 *
 * @param accessToken TMDB bearer access token
 */
public record TmdbAuth(String accessToken) implements Serializable {

    /**
     * Creates a new TMDB authentication value.
     *
     * @param accessToken the TMDB bearer access token
     * @throws IllegalArgumentException if the access token is {@code null}, blank or empty
     */
    public TmdbAuth {
        if (accessToken == null || accessToken.isBlank()) {
            throw new IllegalArgumentException("TMDB access token must not be blank");
        }

        accessToken = accessToken.trim();
    }

    /**
     * Creates authentication from a TMDB bearer access token.
     *
     * @param accessToken the TMDB bearer access token
     * @return a new TMDB authentication value
     * @throws IllegalArgumentException if the access token is {@code null}, blank or empty
     */
    public static TmdbAuth bearerToken(String accessToken) {
        return new TmdbAuth(accessToken);
    }

    /**
     * Returns the value for the HTTP {@code Authorization} header.
     *
     * @return the authorization header value in the format {@code Bearer <token>}
     */
    public String authorizationHeaderValue() {
        return "Bearer " + accessToken;
    }

    /**
     * Returns a masked string representation to avoid leaking the access token.
     *
     * @return a masked string representation
     */
    @Override
    public String toString() {
        return "TmdbAuth[accessToken=***]";
    }
}
