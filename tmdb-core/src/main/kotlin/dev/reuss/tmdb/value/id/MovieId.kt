package dev.reuss.tmdb.value.id

/**
 * TMDB movie id.
 *
 * @property value TMDB movie id
 */
class MovieId private constructor(
    value: Int
) : NumericTmdbResourceId(value, "Movie id") {

    companion object {
        @JvmStatic
        fun of(value: Int): MovieId = MovieId(value)
    }
}