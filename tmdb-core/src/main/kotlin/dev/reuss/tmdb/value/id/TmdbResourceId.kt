package dev.reuss.tmdb.value.id

import java.io.Serializable

/**
 * Common contract for type-safe TMDB resource identifiers.
 *
 * TMDB uses both numeric ids and opaque string ids depending on the endpoint.
 * This interface defines the shared behavior needed by the SDK: rendering
 * the id as a request path segment.
 */
interface TmdbResourceId : Serializable {
    /**
     * Produces the normalized identifier used as an API path segment.
     */
    fun asString(): String
}
