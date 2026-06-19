package dev.reuss.tmdb.core.http;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents a TMDB HTTP request.
 *
 * <p>A request consists of a path relative to the configured TMDB base URL
 * and optional query parameters. Paths must start with {@code /}, for example
 * {@code /configuration} or {@code /movie/550}.</p>
 *
 * <p>This record does not contain the HTTP method explicitly yet, because the
 * current SDK core only supports GET requests.</p>
 *
 * @param path        the request path relative to the TMDB API base URL
 * @param queryParams the request query parameters
 */
public record TmdbRequest(
        String path,
        Map<String, String> queryParams
) implements Serializable {
    /**
     * Creates a request without query parameters.
     *
     * @param path the request path relative to the TMDB API base URL
     */
    public TmdbRequest(String path) {
        this(path, Map.of());
    }

    /**
     * Creates a new TMDB request.
     *
     * @throws IllegalArgumentException if {@code path} is {@code null}, blank,
     *                                  empty or does not start with {@code /}
     */
    public TmdbRequest {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Path must not be blank");
        }

        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("Path must start with '/'");
        }

        queryParams = queryParams == null
                ? Map.of()
                : Map.copyOf(queryParams);
    }

    /**
     * Creates a GET request without query parameters.
     *
     * @param path the request path relative to the TMDB API base URL
     * @return a new TMDB request
     */
    public static TmdbRequest get(String path) {
        return new TmdbRequest(path);
    }

    /**
     * Creates a GET request with query parameters.
     *
     * @param path        the request path relative to the TMDB API base URL
     * @param queryParams the query parameters to include
     * @return a new TMDB request
     */
    public static TmdbRequest get(String path, QueryParams queryParams) {
        return new TmdbRequest(
                path,
                queryParams == null ? Map.of() : queryParams.toMap()
        );
    }
}
