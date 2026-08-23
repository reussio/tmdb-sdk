package dev.reuss.tmdb.core.auth

import java.io.Serializable

/**
 * Bearer authentication for TMDB API requests.
 *
 * TMDB API requests are authenticated with a bearer access token.
 * This value object stores the raw access token and can create the
 * corresponding HTTP `Authorization` header value.
 *
 * The access token is intentionally masked in [toString] to
 * avoid accidentally exposing credentials in logs or debug output.
 *
 * @property accessToken Trimmed TMDB API read access token.
 */
class TmdbAuth private constructor(
    val accessToken: String,
) : Serializable {
    /** Produces the HTTP `Authorization` value in `Bearer <token>` form. */
    fun authorizationHeaderValue(): String = "Bearer $accessToken"

    /** Produces a representation that never includes the access token. */
    override fun toString(): String = "TmdbAuth[accessToken=***]"

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TmdbAuth &&
            accessToken == other.accessToken
    }

    override fun hashCode(): Int = accessToken.hashCode()

    companion object {
        /**
         * Creates authentication from a TMDB API read access token.
         *
         * Leading and trailing whitespace is removed.
         *
         * @throws IllegalArgumentException if [accessToken] is blank
         */
        @JvmStatic
        fun bearerToken(accessToken: String): TmdbAuth {
            require(accessToken.isNotBlank()) {
                "TMDB access token must not be blank"
            }

            return TmdbAuth(accessToken.trim())
        }
    }
}
