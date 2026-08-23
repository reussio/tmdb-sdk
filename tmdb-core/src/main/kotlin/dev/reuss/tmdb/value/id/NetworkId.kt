package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB network resource.
 */
class NetworkId private constructor(
    value: Int
) : NumericTmdbResourceId(value, "Network id") {

    companion object {
        @JvmStatic
        fun of(value: Int): NetworkId = NetworkId(value)
    }
}