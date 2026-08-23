package dev.reuss.tmdb.util

/**
 * Utility methods for normalizing collection values returned by TMDB.
 */
object TmdbCollections {

    @JvmStatic
    fun <T> list(values: List<T>?): List<T> =
        values?.let { java.util.List.copyOf(it) } ?: emptyList()

    @JvmStatic
    fun <K, V> map(values: Map<K, V>?): Map<K, V> =
        values?.let { java.util.Map.copyOf(it) } ?: emptyMap()
}