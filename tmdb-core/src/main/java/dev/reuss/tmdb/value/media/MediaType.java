package dev.reuss.tmdb.value.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * TMDB media type discriminator used in mixed responses.
 */
public enum MediaType {
    MOVIE("movie"),
    TV("tv"),
    PERSON("person"),
    UNKNOWN("unknown");

    private final String value;

    MediaType(String value) {
        this.value = value;
    }

    /**
     * Returns the TMDB media type value.
     *
     * @return media type value
     */
    @JsonValue
    public String value() {
        return value;
    }

    /**
     * Parses a TMDB media type value.
     *
     * @param value raw media type value
     * @return matching media type, or {@link #UNKNOWN} if the value is absent or unknown
     */
    @JsonCreator
    public static MediaType fromValue(String value) {
        if (value == null) {
            return UNKNOWN;
        }

        for (MediaType mediaType : values()) {
            if (mediaType.value.equals(value)) {
                return mediaType;
            }
        }

        return UNKNOWN;
    }
}
