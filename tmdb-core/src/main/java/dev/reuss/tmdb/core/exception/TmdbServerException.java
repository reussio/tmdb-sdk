package dev.reuss.tmdb.core.exception;

public final class TmdbServerException extends TmdbApiException {

    public TmdbServerException(String message, int httpStatus, int tmdbStatusCode, String responseBody) {
        super(message, httpStatus, tmdbStatusCode, responseBody);
    }
}