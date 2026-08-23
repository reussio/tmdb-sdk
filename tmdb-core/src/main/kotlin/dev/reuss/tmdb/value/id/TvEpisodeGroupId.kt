package dev.reuss.tmdb.value.id

/**
 * TMDB TV episode group id.
 */
class TvEpisodeGroupId private constructor(
    value: String,
) : StringTmdbResourceId(value, "TV episode group id") {
    companion object {
        @JvmStatic
        fun of(value: String): TvEpisodeGroupId = TvEpisodeGroupId(value)
    }
}
