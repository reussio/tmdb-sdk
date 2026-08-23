package dev.reuss.tmdb.core.exception

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * JSON error envelope returned by TMDB.
 *
 * @property success Whether TMDB reports the operation as successful.
 * @property statusCode TMDB-specific status code.
 * @property statusMessage Human-readable TMDB status message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class TmdbErrorResponse(
    val success: Boolean,
    @all:JsonProperty("status_code")
    val statusCode: Int,
    @all:JsonProperty("status_message")
    val statusMessage: String,
)
