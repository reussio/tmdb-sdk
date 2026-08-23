package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB keyword resource.
 */
class KeywordId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "Keyword id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): KeywordId = KeywordId(value)
    }
}
