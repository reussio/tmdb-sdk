package dev.reuss.tmdb.core.exception;

/**
 * Exception thrown when a TMDB response cannot be mapped to the expected model.
 */
public class TmdbMappingException extends TmdbException {

    public TmdbMappingException(String message) {
        super(message);
    }

    public TmdbMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
