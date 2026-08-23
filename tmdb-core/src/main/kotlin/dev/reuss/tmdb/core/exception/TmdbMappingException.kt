package dev.reuss.tmdb.core.exception

/**
 * Successful TMDB response that cannot be mapped to the requested model type.
 */
class TmdbMappingException
    @JvmOverloads
    constructor(
        message: String,
        cause: Throwable? = null,
    ) : TmdbException(message, cause)
