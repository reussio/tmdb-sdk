package dev.reuss.tmdb.value.id

/**
 * TMDB TV season id.
 */
class TvSeasonId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "TV season id") {
    companion object {
        @JvmStatic
        fun of(value: Int): TvSeasonId = TvSeasonId(value)
    }
}
