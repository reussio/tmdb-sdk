package dev.reuss.tmdb.core.exception

/**
 * Exception thrown when TMDB reports that a requested resource was not found.
 *
 * @property message error message
 * @property httpStatus HTTP status code
 * @property tmdbStatusCode TMDB status code, or `0` if unavailable
 * @property responseBody raw response body
 */
class TmdbNotFoundException(
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
