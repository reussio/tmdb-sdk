package dev.reuss.tmdb.core.http

import java.io.Serializable
import java.util.Collections

/**
 * Represents a TMDB HTTP request.
 *
 * A request consists of a path relative to the configured TMDB base URL
 * and optional query parameters. Paths must start with `/`, for example
 * `/configuration` or `/movie/550`.
 *
 * This class does not contain the HTTP method explicitly yet, because the
 * current SDK core only supports GET requests.
 *
 * @property path the request path relative to the TMDB API base URL
 * @property queryParams the request query parameters
 */
class TmdbRequest private constructor(
    val path: String,
    queryParams: Map<String, String>?,
) : Serializable {
    val queryParams: Map<String, String> =
        queryParams?.let {
            Collections.unmodifiableMap(LinkedHashMap(it))
        } ?: emptyMap()

    init {
        require(path.isNotBlank()) {
            "Path must not be blank"
        }

        require(path.startsWith("/")) {
            "Path must start with '/'"
        }
    }

    override fun equals(other: Any?): Boolean =
        this === other ||
            (
                other is TmdbRequest &&
                    path == other.path &&
                    queryParams == other.queryParams
            )

    override fun hashCode(): Int = 31 * path.hashCode() + queryParams.hashCode()

    override fun toString(): String = "TmdbRequest(path=$path, queryParams=$queryParams)"

    companion object {
        /**
         * Creates a GET request without query parameters.
         */
        @JvmStatic
        fun get(path: String): TmdbRequest = TmdbRequest(path, emptyMap())

        /**
         * Creates a GET request with query parameters.
         */
        @JvmStatic
        fun get(
            path: String,
            queryParams: QueryParams?,
        ): TmdbRequest =
            TmdbRequest(
                path,
                queryParams?.toMap(),
            )
    }
}
