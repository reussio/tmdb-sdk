package dev.reuss.tmdb.value.id;

import java.io.Serializable;

/**
 * Marker interface for strongly typed TMDB resource identifiers.
 *
 * <p>TMDB uses both numeric ids and opaque string ids depending on the endpoint.
 * This interface only defines the shared behavior needed by the SDK: rendering
 * the id as a request path segment.</p>
 */
public interface TmdbResourceId extends Serializable {

    /**
     * Returns the raw TMDB resource id as it should appear in request paths.
     *
     * @return the id value as a string
     */
    String asString();
}
