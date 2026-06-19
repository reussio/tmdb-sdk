package dev.reuss.tmdb.core.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbErrorResponse(
        boolean success,

        @JsonProperty("status_code")
        int statusCode,

        @JsonProperty("status_message")
        String statusMessage
) {
}
