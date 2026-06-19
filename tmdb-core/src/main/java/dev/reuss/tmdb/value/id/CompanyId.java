package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB company resource.
 *
 * @param value the raw TMDB company id
 */
public record CompanyId(int value) implements NumericTmdbResourceId {

    public CompanyId {
        if (value <= 0) {
            throw new IllegalArgumentException("Company id must be greater than 0");
        }
    }

    public static CompanyId of(int value) {
        return new CompanyId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
