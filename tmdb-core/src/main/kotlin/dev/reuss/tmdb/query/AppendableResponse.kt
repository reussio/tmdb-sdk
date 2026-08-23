package dev.reuss.tmdb.query

import java.io.Serializable

/**
 * Endpoint-specific section that can be requested through `append_to_response`.
 *
 * Implementations are intended for endpoint groups that support appended
 * responses and expose both the raw TMDB query value and the expected response
 * model type.
 */
interface AppendableResponse : Serializable {
    /**
     * Wire value used in the comma-separated query parameter.
     */
    val value: String

    /**
     * Model type used for the appended JSON section.
     */
    val responseType: Class<*>
}
