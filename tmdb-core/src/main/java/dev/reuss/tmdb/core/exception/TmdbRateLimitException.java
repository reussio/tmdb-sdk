package dev.reuss.tmdb.core.exception;

/**
 * Exception thrown when TMDB rejects a request because the rate limit was exceeded.
 */
public final class TmdbRateLimitException extends TmdbApiException {

    /**
     * Creates a rate-limit API exception.
     *
     * @param message error message
     * @param httpStatus HTTP status code
     * @param tmdbStatusCode TMDB status code, or {@code 0} if unavailable
     * @param responseBody raw response body
     */
    public TmdbRateLimitException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}
