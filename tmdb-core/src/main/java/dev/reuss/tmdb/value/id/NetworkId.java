package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB network resource.
 *
 * @param value the raw TMDB network id
 */
public record NetworkId(int value) implements NumericTmdbResourceId {

    public NetworkId {
        if (value <= 0) {
            throw new IllegalArgumentException("Network id must be greater than 0");
        }
    }

    public static NetworkId of(int value) {
        return new NetworkId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
