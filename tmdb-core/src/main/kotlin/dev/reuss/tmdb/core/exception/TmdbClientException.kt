package dev.reuss.tmdb.core.exception

/**
 * Exception thrown when the SDK cannot complete a request before receiving a TMDB response.
 *
 * @property message detail message
 * @property cause cause of the failure
 */
class TmdbClientException(
    message: String,
    cause: Throwable
) : TmdbException(message, cause)