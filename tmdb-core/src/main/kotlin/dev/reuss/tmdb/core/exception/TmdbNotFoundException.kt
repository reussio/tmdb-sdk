package dev.reuss.tmdb.core.exception

/**
 * TMDB API response indicating that the requested resource was not found.
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
