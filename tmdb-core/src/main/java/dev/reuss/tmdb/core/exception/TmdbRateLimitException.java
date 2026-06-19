package dev.reuss.tmdb.core.exception;

public final class TmdbRateLimitException extends TmdbApiException {

    public TmdbRateLimitException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}
