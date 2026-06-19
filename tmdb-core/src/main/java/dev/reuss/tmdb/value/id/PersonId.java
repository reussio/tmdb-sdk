package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB person resource.
 *
 * @param value the raw TMDB person id
 */
public record PersonId(int value) implements NumericTmdbResourceId {

    public PersonId {
        if (value <= 0) {
            throw new IllegalArgumentException("Person id must be greater than 0");
        }
    }

    public static PersonId of(int value) {
        return new PersonId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
