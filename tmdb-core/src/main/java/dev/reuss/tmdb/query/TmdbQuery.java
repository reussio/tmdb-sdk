package dev.reuss.tmdb.query;

import dev.reuss.tmdb.core.http.QueryParams;

import java.io.Serializable;

/**
 * Common contract for TMDB query parameter objects.
 */
public interface TmdbQuery extends Serializable {

    QueryParams toQueryParams();
}
