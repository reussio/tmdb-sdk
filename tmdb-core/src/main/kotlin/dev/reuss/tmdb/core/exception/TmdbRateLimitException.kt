package dev.reuss.tmdb.core.exception

/**
 * Exception thrown when TMDB rejects a request because the rate limit was exceeded.
 *
 * @property message error message
 * @property httpStatus HTTP status code
 * @property tmdbStatusCode TMDB status code, or `0` if unavailable
 * @property responseBody raw response body
 */
class TmdbRateLimitException(
    message: String,
    httpStatus: Int,
    tmdbStatusCode: Int,
    responseBody: String
) : TmdbApiException(
    message,
    httpStatus,
    tmdbStatusCode,
    responseBody
)