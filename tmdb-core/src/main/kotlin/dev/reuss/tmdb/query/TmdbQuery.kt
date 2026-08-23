package dev.reuss.tmdb.query

import dev.reuss.tmdb.core.http.QueryParams
import java.io.Serializable

/**
 * Common contract for TMDB query parameter objects.
 */
interface TmdbQuery : Serializable {

    fun toQueryParams(): QueryParams
}