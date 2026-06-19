package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB credit resource.
 *
 * <p>TMDB credit ids are string values.</p>
 *
 * @param value the raw TMDB credit id
 */
public record CreditId(String value) implements TmdbResourceId {

    public CreditId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Credit id must not be blank");
        }

        value = value.trim();
    }

    public static CreditId of(String value) {
        return new CreditId(value);
    }

    @Override
    public String asString() {
        return value;
    }
}