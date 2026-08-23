package dev.reuss.tmdb.value.id

/**
 * Type-safe TMDB collection id.
 */
class CollectionId private constructor(
    value: Int
) : NumericTmdbResourceId(value, "Collection id") {

    companion object {
        @JvmStatic
        fun of(value: Int): CollectionId = CollectionId(value)
    }
}