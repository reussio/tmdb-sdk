package dev.reuss.tmdb.core.exception

/**
 * Exception thrown when a TMDB response cannot be mapped to the expected model.
 *
 * @property message detail message
 * @property cause cause of the failure
 */
class TmdbMappingException @JvmOverloads constructor(
    message: String,
    cause: Throwable? = null
) : TmdbException(message, cause)