package dev.reuss.tmdb.value.id;

/**
 * TV season number.
 *
 * @param value season number
 */
public record TvSeasonNumber(int value) implements NumericTmdbResourceId {

    public TvSeasonNumber {
        if (value < 0) {
            throw new IllegalArgumentException("TV season number must not be negative");
        }
    }

    public static TvSeasonNumber of(int value) {
        return new TvSeasonNumber(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}