package dev.reuss.tmdb.common.name;

import java.util.List;

/**
 * Common contract for TMDB responses that contain alternative names.
 *
 * @param <T> alternative name item type
 */
public interface AlternativeNamesResponse<T> {

    /**
     * Returns the alternative names contained in the response.
     *
     * @return immutable list of alternative names
     */
    List<T> results();

    /**
     * Returns whether the response contains no alternative names.
     *
     * @return {@code true} if there are no alternative names
     */
    default boolean isEmpty() {
        return results().isEmpty();
    }

    /**
     * Returns whether the response contains at least one alternative name.
     *
     * @return {@code true} if alternative names are present
     */
    default boolean hasAlternativeNames() {
        return !isEmpty();
    }

    /**
     * Returns the number of alternative names.
     *
     * @return alternative name count
     */
    default int alternativeNameCount() {
        return results().size();
    }
}