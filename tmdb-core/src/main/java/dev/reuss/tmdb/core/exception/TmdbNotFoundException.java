package dev.reuss.tmdb.core.exception;

public final class TmdbNotFoundException extends TmdbApiException {

    public TmdbNotFoundException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}