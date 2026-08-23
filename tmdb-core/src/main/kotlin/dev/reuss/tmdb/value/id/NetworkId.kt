package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB network resource.
 */
class NetworkId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "Network id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): NetworkId = NetworkId(value)
    }
}
