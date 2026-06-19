package dev.reuss.tmdb.core.exception;

import java.util.Optional;

/**
 * Exception thrown when TMDB returns an error response.
 */
public class TmdbApiException extends TmdbException {

    private final int httpStatus;
    private final int tmdbStatusCode;
    private final String responseBody;
    private final TmdbError error;

    /**
     * Creates an API exception from TMDB response details.
     *
     * @param message error message
     * @param httpStatus HTTP status code
     * @param tmdbStatusCode TMDB status code, or {@code 0} if unavailable
     * @param responseBody raw response body
     */
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

    /**
     * Returns the HTTP status code.
     *
     * @return HTTP status code
     */
    public int httpStatus() {
        return httpStatus;
    }

    /**
     * Returns the TMDB status code.
     *
     * @return TMDB status code, or {@code 0} if unavailable
     */
    public int tmdbStatusCode() {
        return tmdbStatusCode;
    }

    /**
     * Returns the raw response body.
     *
     * @return raw response body
     */
    public String responseBody() {
        return responseBody;
    }

    /**
     * Returns the known TMDB error matching {@link #tmdbStatusCode()}.
     *
     * @return known TMDB error, if recognized
     */
    public Optional<TmdbError> error() {
        return Optional.ofNullable(error);
    }
}
