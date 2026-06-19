package dev.reuss.tmdb.common.title;

import java.util.List;

/**
 * Common contract for TMDB responses that contain alternative titles.
 */
public interface AlternativeTitlesResponse {

    /**
     * Returns the alternative titles contained in the response.
     *
     * @return immutable list of alternative titles
     */
    List<AlternativeTitle> alternativeTitles();

    /**
     * Returns whether the response contains no alternative titles.
     *
     * @return {@code true} if there are no alternative titles
     */
    default boolean isEmpty() {
        return alternativeTitles().isEmpty();
    }

    /**
     * Returns whether the response contains at least one alternative title.
     *
     * @return {@code true} if alternative titles are present
     */
    default boolean hasAlternativeTitles() {
        return !isEmpty();
    }

    /**
     * Returns the number of alternative titles.
     *
     * @return alternative title count
     */
    default int alternativeTitleCount() {
        return alternativeTitles().size();
    }
}