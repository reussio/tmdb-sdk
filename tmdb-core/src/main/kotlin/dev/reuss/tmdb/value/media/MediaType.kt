package dev.reuss.tmdb.value.media

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
 * TMDB media discriminator used by mixed search and trending responses.
 */
enum class MediaType(
    @get:JsonValue
    val value: String,
) {
    MOVIE("movie"),
    TV("tv"),
    PERSON("person"),
    UNKNOWN("unknown"),
    ;

    companion object {
        /**
         * Maps a wire value to a known media type without throwing.
         *
         * @return matching media type, or [UNKNOWN] if the value is absent or unknown
         */
        @JvmStatic
        @JsonCreator
        fun fromValue(value: String?): MediaType = entries.firstOrNull { it.value == value } ?: UNKNOWN
    }
}
