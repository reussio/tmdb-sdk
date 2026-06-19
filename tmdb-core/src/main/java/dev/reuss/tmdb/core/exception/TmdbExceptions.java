package dev.reuss.tmdb.core.exception;

public final class TmdbExceptions {

    private TmdbExceptions() {
    }

    public static TmdbApiException from(
            int httpStatus,
            int tmdbStatusCode,
            String tmdbStatusMessage,
            String responseBody
    ) {
        return switch (httpStatus) {
            case 401, 403 -> new TmdbUnauthorizedException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody
            );
            case 404 -> new TmdbNotFoundException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody
            );
            case 429 -> new TmdbRateLimitException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody
            );
            case 500, 501, 502, 503, 504 -> new TmdbServerException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody
            );
            default -> new TmdbApiException(
                    tmdbStatusMessage,
                    httpStatus,
                    tmdbStatusCode,
                    responseBody
            );
        };
    }

    public static TmdbApiException fromHttpStatus(
            int httpStatus,
            String message,
            String responseBody
    ) {
        return switch (httpStatus) {
            case 401, 403 -> new TmdbUnauthorizedException(
                    message,
                    httpStatus,
                    0,
                    responseBody
            );
            case 404 -> new TmdbNotFoundException(
                    message,
                    httpStatus,
                    0,
                    responseBody
            );
            case 429 -> new TmdbRateLimitException(
                    message,
                    httpStatus,
                    0,
                    responseBody
            );
            case 500, 501, 502, 503, 504 -> new TmdbServerException(
                    message,
                    httpStatus,
                    0,
                    responseBody
            );
            default -> new TmdbApiException(
                    message,
                    httpStatus,
                    0,
                    responseBody
            );
        };
    }
}