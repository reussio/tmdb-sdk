package dev.reuss.tmdb.core.exception;

/**
 * Exception thrown when TMDB reports that a requested resource was not found.
 */
public final class TmdbNotFoundException extends TmdbApiException {

    /**
     * Creates a not-found API exception.
     *
     * @param message error message
     * @param httpStatus HTTP status code
     * @param tmdbStatusCode TMDB status code, or {@code 0} if unavailable
     * @param responseBody raw response body
     */
    public TmdbNotFoundException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}
