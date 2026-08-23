package dev.reuss.tmdb.core.exception

/**
 * Exception thrown when TMDB or an upstream server returns a server-side error.
 *
 * @property message error message
 * @property httpStatus HTTP status code
 * @property tmdbStatusCode TMDB status code, or `0` if unavailable
 * @property responseBody raw response body
 */
class TmdbServerException(
    message: String,
    httpStatus: Int,
    tmdbStatusCode: Int,
    responseBody: String,
) : TmdbApiException(
        message,
        httpStatus,
        tmdbStatusCode,
        responseBody,
    )
