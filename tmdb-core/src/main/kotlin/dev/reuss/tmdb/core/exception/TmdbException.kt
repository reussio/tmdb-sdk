package dev.reuss.tmdb.core.exception

/**
 * Base unchecked exception for SDK failures.
 *
 * @property message detail message
 * @property cause cause of the failure
 */
open class TmdbException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
