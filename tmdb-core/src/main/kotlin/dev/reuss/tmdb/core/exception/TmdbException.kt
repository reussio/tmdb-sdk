package dev.reuss.tmdb.core.exception

/**
 * Base unchecked exception for failures reported by the SDK.
 *
 * Callers can catch its specialized subclasses to distinguish TMDB API errors,
 * transport failures, and response-mapping failures.
 */
open class TmdbException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
