package dev.reuss.tmdb.value.id;

/**
 * TMDB TV episode group id.
 *
 * @param value TMDB TV episode group id
 */
public record TvEpisodeGroupId(String value) implements TmdbResourceId {

    public TvEpisodeGroupId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("TV episode group id must not be blank");
        }

        value = value.trim();
    }

    public static TvEpisodeGroupId of(String value) {
        return new TvEpisodeGroupId(value);
    }

    @Override
    public String asString() {
        return value;
    }
}