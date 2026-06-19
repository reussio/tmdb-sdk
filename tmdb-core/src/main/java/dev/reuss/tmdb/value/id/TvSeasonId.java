package dev.reuss.tmdb.value.id;

/**
 * TMDB TV season id.
 *
 * @param value TMDB TV season id
 */
public record TvSeasonId(int value) implements NumericTmdbResourceId {

    public TvSeasonId {
        if (value <= 0) {
            throw new IllegalArgumentException("TV season id must be greater than 0");
        }
    }

    public static TvSeasonId of(int value) {
        return new TvSeasonId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
