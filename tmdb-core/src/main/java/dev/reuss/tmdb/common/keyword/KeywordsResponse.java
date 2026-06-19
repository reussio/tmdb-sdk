package dev.reuss.tmdb.common.keyword;

import java.util.List;

/**
 * Common contract for TMDB responses that contain keywords.
 */
public interface KeywordsResponse {

    /**
     * Returns the keywords contained in the response.
     *
     * @return immutable list of keywords
     */
    List<Keyword> keywords();

    /**
     * Returns whether the response contains no keywords.
     *
     * @return {@code true} if there are no keywords
     */
    default boolean isEmpty() {
        return keywords().isEmpty();
    }

    /**
     * Returns whether the response contains at least one keyword.
     *
     * @return {@code true} if keywords are present
     */
    default boolean hasKeywords() {
        return !isEmpty();
    }

    /**
     * Returns the number of keywords in the response.
     *
     * @return keyword count
     */
    default int keywordCount() {
        return keywords().size();
    }
}