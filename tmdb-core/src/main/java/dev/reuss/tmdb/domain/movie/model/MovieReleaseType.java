package dev.reuss.tmdb.domain.movie.model;

/**
 * Movie release type.
 */
public enum MovieReleaseType {

    PREMIERE(1),
    THEATRICAL_LIMITED(2),
    THEATRICAL(3),
    DIGITAL(4),
    PHYSICAL(5),
    TV(6);

    private final int value;

    MovieReleaseType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static MovieReleaseType fromValue(int value) {
        for (MovieReleaseType type : values()) {
            if (type.value == value) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown movie release type: " + value);
    }
}
