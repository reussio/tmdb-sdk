package dev.reuss.tmdb.value.media

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
 * TMDB media type discriminator used in mixed responses.
 */
enum class MediaType(
    @get:JsonValue
    val value: String
) {
    MOVIE("movie"),
    TV("tv"),
    PERSON("person"),
    UNKNOWN("unknown");

    companion object {

        /**
         * Parses a TMDB media type value.
         *
         * @return matching media type, or [UNKNOWN] if the value is absent or unknown
         */
        @JvmStatic
        @JsonCreator
        fun fromValue(value: String?): MediaType =
            entries.firstOrNull { it.value == value } ?: UNKNOWN
    }
}