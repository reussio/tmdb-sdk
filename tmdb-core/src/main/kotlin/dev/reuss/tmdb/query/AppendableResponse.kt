package dev.reuss.tmdb.query

import java.io.Serializable

/**
 * Common contract for TMDB `append_to_response` values.
 *
 * Implementations are intended for endpoint groups that support appended
 * responses and expose both the raw TMDB query value and the expected response
 * model type.
 */
interface AppendableResponse : Serializable {
    /**
     * TMDB `append_to_response` query value.
     */
    val value: String

    /**
     * Response model type for this appended response.
     */
    val responseType: Class<*>
}
