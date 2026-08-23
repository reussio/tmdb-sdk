package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB TV show resource.
 *
 * TMDB TV show ids are represented as signed 32-bit integer values in the
 * API schema. This class wraps the raw id value to avoid mixing TV show ids
 * with other TMDB resource ids such as movie or person ids.
 */
class TvShowId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "TV series id") {
    companion object {
        @JvmStatic
        fun of(value: Int): TvShowId = TvShowId(value)
    }
}
