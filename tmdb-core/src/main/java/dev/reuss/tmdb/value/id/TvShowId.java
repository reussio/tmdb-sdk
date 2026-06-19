package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB TV show resource.
 *
 * <p>TMDB TV show ids are represented as signed 32-bit integer values in the
 * API schema. This record wraps the raw id value to avoid mixing TV show ids
 * with other TMDB resource ids such as movie or person ids.</p>
 *
 * @param value the raw TMDB TV show id
 */
public record TvShowId(int value) implements NumericTmdbResourceId {

    public TvShowId {
        if (value <= 0) {
            throw new IllegalArgumentException("TV series id must be greater than 0");
        }
    }

    /**
     * Creates a new TV show id.
     *
     * @param value the raw TMDB TV show id
     * @return a new TV show id value
     */
    public static TvShowId of(int value) {
        return new TvShowId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
