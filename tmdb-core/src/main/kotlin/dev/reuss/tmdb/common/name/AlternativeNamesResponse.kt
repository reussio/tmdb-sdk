package dev.reuss.tmdb.common.name

/**
 * Common contract for TMDB responses that contain alternative names.
 *
 * @property <T> alternative name item type
 */

interface AlternativeNamesResponse<T> {

    val results: List<T>

    fun isEmpty(): Boolean {
        return results.isEmpty()
    }

    fun hasAlternativeNames(): Boolean {
        return !isEmpty()
    }

    fun alternativeNameCount(): Int {
        return results.size
    }
}
