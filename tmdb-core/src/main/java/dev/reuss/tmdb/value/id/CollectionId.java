package dev.reuss.tmdb.value.id;

/**
 * Type-safe TMDB collection id.
 *
 * @param value raw TMDB collection id
 */
public record CollectionId(int value) implements NumericTmdbResourceId {

    public CollectionId {
        if (value <= 0) {
            throw new IllegalArgumentException("Collection id must be greater than 0");
        }
    }

    public static CollectionId of(int value) {
        return new CollectionId(value);
    }
}
