package dev.reuss.tmdb.common.translation

/**
 * Common contract for TMDB responses that contain translations.
 *
 * @property <T> translation data type
 */

interface TranslationsResponse<T> {
    val translations: List<Translation<T>>

    fun isEmpty(): Boolean = translations.isEmpty()

    fun hasTranslations(): Boolean = !isEmpty()

    fun translationCount(): Int = translations.size
}
