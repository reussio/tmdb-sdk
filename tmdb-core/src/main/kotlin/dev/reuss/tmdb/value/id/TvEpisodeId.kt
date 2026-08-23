package dev.reuss.tmdb.value.id

/**
 * TMDB TV episode id.
 */
class TvEpisodeId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "TV episode id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): TvEpisodeId = TvEpisodeId(value)
    }
}
