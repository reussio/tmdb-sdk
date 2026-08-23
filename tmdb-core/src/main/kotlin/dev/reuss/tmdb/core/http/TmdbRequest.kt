package dev.reuss.tmdb.core.http

import java.io.Serializable
import java.util.Collections

/**
 * Immutable description of a TMDB GET request.
 *
 * A request consists of a path relative to the configured TMDB base URL
 * and optional query parameters. Paths must start with `/`, for example
 * `/configuration` or `/movie/550`.
 *
 * Query parameters are copied when the request is created.
 *
 * @property path Path relative to the configured API base URL; it must begin with `/`.
 * @property queryParams Immutable query-parameter snapshot.
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
         * Creates a request without query parameters.
         *
         * @throws IllegalArgumentException if [path] is blank or does not start with `/`
         */
        @JvmStatic
        fun get(path: String): TmdbRequest = TmdbRequest(path, emptyMap())

        /**
         * Creates a request from a snapshot of [queryParams].
         *
         * @throws IllegalArgumentException if [path] is blank or does not start with `/`
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
