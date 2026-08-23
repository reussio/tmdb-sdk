package dev.reuss.tmdb.core.exception

import java.util.Optional

/**
 * Exception thrown when TMDB returns an error response.
 *
 * @property httpStatus HTTP status code
 * @property tmdbStatusCode TMDB status code, or `0` if unavailable
 * @property responseBody raw response body
 */
open class TmdbApiException(
    message: String,
    val httpStatus: Int,
    val tmdbStatusCode: Int,
    val responseBody: String,
) : TmdbException(message) {
    private val error: TmdbError? =
        TmdbError.fromCode(tmdbStatusCode).orElse(null)

    /**
     * Returns the known TMDB error matching [tmdbStatusCode].
     */
    fun error(): Optional<TmdbError> = Optional.ofNullable(error)
}
