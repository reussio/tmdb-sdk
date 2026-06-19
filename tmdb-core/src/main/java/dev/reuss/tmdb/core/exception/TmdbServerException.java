package dev.reuss.tmdb.core.exception;

/**
 * Exception thrown when TMDB or an upstream server returns a server-side error.
 */
public final class TmdbServerException extends TmdbApiException {

    /**
     * Creates a server API exception.
     *
     * @param message error message
     * @param httpStatus HTTP status code
     * @param tmdbStatusCode TMDB status code, or {@code 0} if unavailable
     * @param responseBody raw response body
     */
    public TmdbServerException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}
