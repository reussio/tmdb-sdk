package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB review resource.
 *
 * TMDB review ids are string values.
 *
 * @property value the raw TMDB review id
 */
class ReviewId private constructor(
    value: String,
) : StringTmdbResourceId(value, "Review id") {
    companion object {
        @JvmStatic
        fun of(value: String): ReviewId = ReviewId(value)
    }
}
