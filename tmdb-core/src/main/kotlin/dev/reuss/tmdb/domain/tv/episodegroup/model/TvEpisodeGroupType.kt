package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

/**
 * TV episode group type.
 */
enum class TvEpisodeGroupType(
    @get:JsonValue
    @all:JsonProperty("value")
    val value: Int,
) {
    ORIGINAL_AIR_DATE(1),
    ABSOLUTE(2),
    DVD(3),
    DIGITAL(4),
    STORY_ARC(5),
    PRODUCTION(6),
    TV(7),
    ;

    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun fromValue(value: Int): TvEpisodeGroupType =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException(
                    "Unknown TV episode group type: $value",
                )
    }
}
