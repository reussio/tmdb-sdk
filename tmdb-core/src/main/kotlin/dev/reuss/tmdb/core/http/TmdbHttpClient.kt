package dev.reuss.tmdb.core.http

import dev.reuss.tmdb.core.exception.TmdbException

/**
 * Executes typed GET requests against a TMDB-compatible API.
 *
 * Domain services depend on this contract rather than a concrete transport.
 * [JavaNetTmdbHttpClient] is used by clients created through the SDK builder.
 */
interface TmdbHttpClient {
    /**
     * Executes [request] and maps its JSON response to [responseType].
     *
     * @throws TmdbException if transport fails, TMDB returns a non-successful
     * response, or the body cannot be mapped
     */
    fun <T> get(
        request: TmdbRequest,
        responseType: Class<T>,
    ): T
}
