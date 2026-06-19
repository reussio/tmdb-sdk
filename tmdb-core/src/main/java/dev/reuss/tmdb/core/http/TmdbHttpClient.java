package dev.reuss.tmdb.core.http;

import dev.reuss.tmdb.core.exception.TmdbException;

/**
 * Abstraction for executing HTTP requests against the TMDB API.
 *
 * <p>This interface is used by SDK services to perform requests without
 * depending directly on a specific HTTP client implementation. The default
 * implementation is based on Java's built-in HTTP client.</p>
 */
public interface TmdbHttpClient {

    /**
     * Sends a GET request and maps the response body to the given Java type.
     *
     * @param request      the TMDB request to execute
     * @param responseType the expected response type
     * @param <T>          the expected response type
     * @return the mapped response body
     * @throws NullPointerException if {@code request} or {@code responseType} is {@code null}
     * @throws TmdbException        if the request fails, TMDB returns a non-successful response,
     *                              or the response body cannot be mapped
     */
    <T> T get(TmdbRequest request, Class<T> responseType);
}
