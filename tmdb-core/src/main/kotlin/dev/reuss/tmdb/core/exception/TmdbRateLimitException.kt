package dev.reuss.tmdb.core.exception

/**
 * TMDB API response indicating that the request limit was exceeded.
 */
class TmdbRateLimitException(
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
