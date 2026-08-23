package dev.reuss.tmdb.core.exception

/**
 * Transport or interruption failure that occurs before a response is available.
 */
class TmdbClientException(
    message: String,
    cause: Throwable,
) : TmdbException(message, cause)
