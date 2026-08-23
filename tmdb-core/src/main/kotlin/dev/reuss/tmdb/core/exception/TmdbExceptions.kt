package dev.reuss.tmdb.core.exception

/**
 * Factory methods for mapping TMDB response status values to SDK exceptions.
 */
object TmdbExceptions {
    /**
     * Creates the most specific API exception for a parsed TMDB error response.
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
     * Creates the most specific API exception for an HTTP error without a parsed TMDB status code.
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
