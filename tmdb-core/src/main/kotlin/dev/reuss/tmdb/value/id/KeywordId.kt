package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB keyword resource.
 */
class KeywordId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "Keyword id") {
    companion object {
        @JvmStatic
        fun of(value: Int): KeywordId = KeywordId(value)
    }
}
