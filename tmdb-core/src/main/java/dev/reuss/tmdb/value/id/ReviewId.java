package dev.reuss.tmdb.value.id;

/**
 * Strongly typed identifier for a TMDB review resource.
 *
 * <p>TMDB review ids are string values.</p>
 *
 * @param value the raw TMDB review id
 */
public record ReviewId(String value) implements TmdbResourceId {

    public ReviewId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Review id must not be blank");
        }

        value = value.trim();
    }

    public static ReviewId of(String value) {
        return new ReviewId(value);
    }

    @Override
    public String asString() {
        return value;
    }
}