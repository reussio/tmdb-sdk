package dev.reuss.tmdb.common.translation

/**
 * Common contract for TMDB responses that contain translations.
 *
 * @property <T> translation data type
 */

interface TranslationsResponse<T> {

    val translations: List<Translation<T>>

    fun isEmpty(): Boolean {
        return translations.isEmpty()
    }

    fun hasTranslations(): Boolean {
        return !isEmpty()
    }

    fun translationCount(): Int {
        return translations.size
    }
}
