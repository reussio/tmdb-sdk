package dev.reuss.tmdb.core.exception;

/**
 * Exception thrown when the SDK cannot complete a request before receiving a TMDB response.
 */
public final class TmdbClientException extends TmdbException {

    /**
     * Creates a client exception with a detail message and cause.
     *
     * @param message detail message
     * @param cause cause of the failure
     */
    public TmdbClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
