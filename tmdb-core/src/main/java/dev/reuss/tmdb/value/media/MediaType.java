package dev.reuss.tmdb.value.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MediaType {
    MOVIE("movie"),
    TV("tv"),
    PERSON("person"),
    UNKNOWN("unknown");

    private final String value;

    MediaType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

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