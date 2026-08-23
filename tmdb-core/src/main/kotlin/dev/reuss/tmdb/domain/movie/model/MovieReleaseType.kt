package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

/**
 * Movie release type.
 *
 * @property value TMDB release type value
 */
enum class MovieReleaseType(
    @get:JsonValue
    @all:JsonProperty("value")
    val value: Int,
) {
    PREMIERE(1),
    THEATRICAL_LIMITED(2),
    THEATRICAL(3),
    DIGITAL(4),
    PHYSICAL(5),
    TV(6),
    ;

    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun fromValue(value: Int): MovieReleaseType =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException(
                    "Unknown movie release type: $value",
                )
    }
}
