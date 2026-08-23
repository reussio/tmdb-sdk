package dev.reuss.tmdb.core.exception

/**
 * TMDB API response indicating failed authentication or insufficient authorization.
 */
class TmdbUnauthorizedException(
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
