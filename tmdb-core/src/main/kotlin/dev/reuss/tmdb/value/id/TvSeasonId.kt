package dev.reuss.tmdb.value.id

/**
 * TMDB TV season id.
 */
class TvSeasonId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "TV season id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): TvSeasonId = TvSeasonId(value)
    }
}
