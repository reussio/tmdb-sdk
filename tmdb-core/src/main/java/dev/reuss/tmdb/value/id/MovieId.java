package dev.reuss.tmdb.value.id;

/**
 * TMDB movie id.
 *
 * @param value TMDB movie id
 */
public record MovieId(int value) implements NumericTmdbResourceId {

    public MovieId {
        if (value <= 0) {
            throw new IllegalArgumentException("Movie id must be greater than 0");
        }
    }

    public static MovieId of(int value) {
        return new MovieId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
