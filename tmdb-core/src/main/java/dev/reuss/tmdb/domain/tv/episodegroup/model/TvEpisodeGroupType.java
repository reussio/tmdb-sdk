package dev.reuss.tmdb.domain.tv.episodegroup.model;

/**
 * TV episode group type.
 */
public enum TvEpisodeGroupType {

    ORIGINAL_AIR_DATE(1),
    ABSOLUTE(2),
    DVD(3),
    DIGITAL(4),
    STORY_ARC(5),
    PRODUCTION(6),
    TV(7);

    private final int value;

    TvEpisodeGroupType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static TvEpisodeGroupType fromValue(int value) {
        for (TvEpisodeGroupType type : values()) {
            if (type.value == value) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown TV episode group type: " + value);
    }
}
