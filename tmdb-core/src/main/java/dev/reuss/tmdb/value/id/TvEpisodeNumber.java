package dev.reuss.tmdb.value.id;

/**
 * TV episode number.
 *
 * @param value episode number
 */
public record TvEpisodeNumber(int value) implements NumericTmdbResourceId {

    public TvEpisodeNumber {
        if (value <= 0) {
            throw new IllegalArgumentException("TV episode number must be greater than 0");
        }
    }

    public static TvEpisodeNumber of(int value) {
        return new TvEpisodeNumber(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}