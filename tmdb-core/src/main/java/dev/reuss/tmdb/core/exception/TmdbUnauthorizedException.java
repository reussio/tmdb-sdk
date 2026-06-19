package dev.reuss.tmdb.core.exception;

public final class TmdbUnauthorizedException extends TmdbApiException {

    public TmdbUnauthorizedException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}
