package dev.reuss.tmdb.value.id

import java.io.Serializable

/**
 * Marker interface for strongly typed TMDB resource identifiers.
 *
 * TMDB uses both numeric ids and opaque string ids depending on the endpoint.
 * This interface defines the shared behavior needed by the SDK: rendering
 * the id as a request path segment.
 */
interface TmdbResourceId : Serializable {

    /**
     * Returns the raw TMDB resource id as it should appear in request paths.
     */
    fun asString(): String
}