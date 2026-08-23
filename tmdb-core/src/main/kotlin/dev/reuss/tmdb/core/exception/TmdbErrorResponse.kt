package dev.reuss.tmdb.core.exception

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Error response returned by TMDB.
 *
 * @property success TMDB success flag
 * @property statusCode TMDB status code
 * @property statusMessage TMDB status message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class TmdbErrorResponse(
    val success: Boolean,
    @all:JsonProperty("status_code")
    val statusCode: Int,
    @all:JsonProperty("status_message")
    val statusMessage: String,
)
