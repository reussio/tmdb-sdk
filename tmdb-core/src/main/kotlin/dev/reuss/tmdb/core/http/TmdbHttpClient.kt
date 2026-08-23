package dev.reuss.tmdb.core.http

import dev.reuss.tmdb.core.exception.TmdbException

/**
 * Abstraction for executing HTTP requests against the TMDB API.
 *
 * This interface is used by SDK services to perform requests without
 * depending directly on a specific HTTP client implementation. The default
 * implementation is based on Java's built-in HTTP client.
 */
interface TmdbHttpClient {

    /**
     * Sends a GET request and maps the response body to the given Java type.
     *
     * @throws TmdbException if the request fails, TMDB returns a non-successful response,
     * or the response body cannot be mapped
     */
    fun <T> get(
        request: TmdbRequest,
        responseType: Class<T>
    ): T
}