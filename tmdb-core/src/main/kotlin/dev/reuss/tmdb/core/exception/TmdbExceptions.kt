package dev.reuss.tmdb.core.exception

/**
 * Maps HTTP and TMDB status information to the public exception hierarchy.
 */
object TmdbExceptions {
    /**
     * Selects the most specific exception supported for [httpStatus].
     *
     * Authentication and authorization errors map to [TmdbUnauthorizedException],
     * `404` to [TmdbNotFoundException], `429` to [TmdbRateLimitException], and
     * `500` through `504` to [TmdbServerException]. Other statuses remain
     * [TmdbApiException].
     */
    @JvmStatic
    fun from(
        httpStatus: Int,
        tmdbStatusCode: Int,
        tmdbStatusMessage: String,
        responseBody: String,
    ): TmdbApiException =
        when (httpStatus) {
            401, 403 -> {
                TmdbUnauthorizedException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody,
                )
            }

            404 -> {
                TmdbNotFoundException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody,
                )
            }

            429 -> {
                TmdbRateLimitException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody,
                )
            }

            in 500..504 -> {
                TmdbServerException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody,
                )
            }

            else -> {
                TmdbApiException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody,
                )
            }
        }

    /**
     * Maps an HTTP error whose body did not yield a TMDB status code.
     */
    @JvmStatic
    fun fromHttpStatus(
        httpStatus: Int,
        message: String,
        responseBody: String,
    ): TmdbApiException =
        from(
            httpStatus = httpStatus,
            tmdbStatusCode = 0,
            tmdbStatusMessage = message,
            responseBody = responseBody,
        )
}
