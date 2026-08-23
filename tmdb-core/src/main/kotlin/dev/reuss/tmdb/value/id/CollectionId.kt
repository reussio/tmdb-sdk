package dev.reuss.tmdb.value.id

/**
 * Type-safe TMDB collection id.
 */
class CollectionId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "Collection id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): CollectionId = CollectionId(value)
    }
}
