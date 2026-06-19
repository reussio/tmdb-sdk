package dev.reuss.tmdb.value.id;

/**
 * Marker interface for numeric TMDB resource identifiers.
 */
public interface NumericTmdbResourceId extends TmdbResourceId {

    /**
     * Returns the raw numeric TMDB resource id value.
     *
     * @return the raw integer id value
     */
    int value();

    @Override
    default String asString() {
        return String.valueOf(value());
    }
}