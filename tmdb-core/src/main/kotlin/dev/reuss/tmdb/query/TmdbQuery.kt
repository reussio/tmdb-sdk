package dev.reuss.tmdb.query

import dev.reuss.tmdb.core.http.QueryParams
import java.io.Serializable

/**
 * Serializable request options that can be converted to TMDB wire parameters.
 */
interface TmdbQuery : Serializable {
    /** Creates a parameter snapshot suitable for a [dev.reuss.tmdb.core.http.TmdbRequest]. */
    fun toQueryParams(): QueryParams
}
