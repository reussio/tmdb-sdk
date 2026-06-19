package dev.reuss.tmdb.core.exception;

/**
 * Exception thrown when TMDB rejects a request because authentication or authorization failed.
 */
public final class TmdbUnauthorizedException extends TmdbApiException {

    /**
     * Creates an unauthorized API exception.
     *
     * @param message error message
     * @param httpStatus HTTP status code
     * @param tmdbStatusCode TMDB status code, or {@code 0} if unavailable
     * @param responseBody raw response body
     */
    public TmdbUnauthorizedException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}
