package dev.reuss.tmdb.value.id

/**
 * TMDB movie id.
 *
 * @property value TMDB movie id
 */
class MovieId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "Movie id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): MovieId = MovieId(value)
    }
}
