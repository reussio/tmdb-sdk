package dev.reuss.tmdb.core.exception;

/**
 * Base unchecked exception for SDK failures.
 */
public class TmdbException extends RuntimeException {

    /**
     * Creates an exception with a detail message.
     *
     * @param message detail message
     */
    public TmdbException(String message) {
        super(message);
    }

    /**
     * Creates an exception with a detail message and cause.
     *
     * @param message detail message
     * @param cause cause of the failure
     */
    public TmdbException(String message, Throwable cause) {
        super(message, cause);
    }
}
