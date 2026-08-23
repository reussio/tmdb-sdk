package dev.reuss.tmdb.core.exception

import java.util.Optional

/**
 * Non-successful HTTP response returned by TMDB.
 *
 * @property httpStatus HTTP status returned by the API.
 * @property tmdbStatusCode TMDB status code, or `0` when the response could not be parsed.
 * @property responseBody Unmodified response body for diagnostics.
 */
open class TmdbApiException(
    message: String,
    val httpStatus: Int,
    val tmdbStatusCode: Int,
    val responseBody: String,
) : TmdbException(message) {
    private val error: TmdbError? =
        TmdbError.fromCode(tmdbStatusCode).orElse(null)

    /** Resolves [tmdbStatusCode] to a known [TmdbError] for Java callers. */
    fun error(): Optional<TmdbError> = Optional.ofNullable(error)
}
