package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB keyword resource.
 *
 * @param value the raw TMDB keyword id
 */
public record KeywordId(int value) implements NumericTmdbResourceId {

    public KeywordId {
        if (value <= 0) {
            throw new IllegalArgumentException("Keyword id must be greater than 0");
        }
    }

    public static KeywordId of(int value) {
        return new KeywordId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
