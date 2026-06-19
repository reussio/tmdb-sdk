package dev.reuss.tmdb.core.exception;

import java.util.Optional;

public class TmdbApiException extends TmdbException {

    private final int httpStatus;
    private final int tmdbStatusCode;
    private final String responseBody;
    private final TmdbError error;

    public TmdbApiException(
            String message,
            int httpStatus,
            int tmdbStatusCode,
            String responseBody
    ) {
        super(message);
        this.httpStatus = httpStatus;
        this.tmdbStatusCode = tmdbStatusCode;
        this.responseBody = responseBody;
        this.error = TmdbError.fromCode(tmdbStatusCode).orElse(null);
    }

    public int httpStatus() {
        return httpStatus;
    }

    public int tmdbStatusCode() {
        return tmdbStatusCode;
    }

    public String responseBody() {
        return responseBody;
    }

    public Optional<TmdbError> error() {
        return Optional.ofNullable(error);
    }
}