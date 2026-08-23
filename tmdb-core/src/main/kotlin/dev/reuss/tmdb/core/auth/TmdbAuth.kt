package dev.reuss.tmdb.core.auth

import java.io.Serializable

/**
 * Represents TMDB API authentication.
 *
 * TMDB API requests are authenticated with a bearer access token.
 * This value object stores the raw access token and can create the
 * corresponding HTTP `Authorization` header value.
 *
 * The access token is intentionally masked in [toString] to
 * avoid accidentally exposing credentials in logs or debug output.
 *
 * @property accessToken TMDB bearer access token
 */
class TmdbAuth private constructor(
    val accessToken: String,
) : Serializable {
    /**
     * Returns the value for the HTTP `Authorization` header.
     *
     * @return the authorization header value in the format `Bearer <token>`
     */
    fun authorizationHeaderValue(): String = "Bearer $accessToken"

    /**
     * Returns a masked string representation to avoid leaking the access token.
     */
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
         * Creates authentication from a TMDB bearer access token.
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
