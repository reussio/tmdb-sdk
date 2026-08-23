package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB TV series resource.
 *
 * TMDB TV series ids are represented as signed 32-bit integer values in the
 * API schema. This class wraps the raw id value to avoid mixing TV series ids
 * with other TMDB resource ids such as movie or person ids.
 */
class TvShowId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "TV series id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): TvShowId = TvShowId(value)
    }
}
