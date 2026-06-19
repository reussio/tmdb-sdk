package dev.reuss.tmdb.value.id;

/**
 * Strongly typed external identifier used to find TMDB objects.
 *
 * <p>External ids are identifiers from third-party systems such as IMDb,
 * TVDB, Wikidata, Facebook, Instagram, TikTok, Twitter or YouTube.</p>
 *
 * @param value the raw external id value
 */
public record ExternalId(String value) implements TmdbResourceId {

    public ExternalId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("External id must not be blank");
        }

        value = value.trim();
    }

    public static ExternalId of(String value) {
        return new ExternalId(value);
    }

    @Override
    public String asString() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
