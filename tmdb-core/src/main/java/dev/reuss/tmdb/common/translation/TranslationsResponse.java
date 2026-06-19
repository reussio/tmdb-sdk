package dev.reuss.tmdb.common.translation;

import java.util.List;

/**
 * Common contract for TMDB responses that contain translations.
 *
 * @param <T> translation data type
 */
public interface TranslationsResponse<T> {

    /**
     * Returns the translations contained in the response.
     *
     * @return immutable list of translations
     */
    List<Translation<T>> translations();

    /**
     * Returns whether the response contains no translations.
     *
     * @return {@code true} if there are no translations
     */
    default boolean isEmpty() {
        return translations().isEmpty();
    }

    /**
     * Returns whether the response contains at least one translation.
     *
     * @return {@code true} if translations are present
     */
    default boolean hasTranslations() {
        return !isEmpty();
    }

    /**
     * Returns the number of translations in the response.
     *
     * @return translation count
     */
    default int translationCount() {
        return translations().size();
    }
}