package dev.reuss.tmdb.value.id

/**
 * TMDB TV episode id.
 */
class TvEpisodeId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "TV episode id") {
    companion object {
        @JvmStatic
        fun of(value: Int): TvEpisodeId = TvEpisodeId(value)
    }
}
