package dev.reuss.tmdb.core.exception

/**
 * Server-side TMDB or upstream failure with HTTP status `500` through `504`.
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
