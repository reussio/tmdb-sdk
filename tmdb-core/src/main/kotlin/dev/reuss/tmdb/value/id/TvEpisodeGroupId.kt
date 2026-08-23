package dev.reuss.tmdb.value.id

/**
 * TMDB TV episode group id.
 */
class TvEpisodeGroupId private constructor(
    value: String,
) : StringTmdbResourceId(value, "TV episode group id") {
    companion object {
        /**
         * Creates an identifier from a non-blank value.
         *
         * Leading and trailing whitespace is removed.
         *
         * @throws IllegalArgumentException if [value] is blank
         */
        @JvmStatic
        fun of(value: String): TvEpisodeGroupId = TvEpisodeGroupId(value)
    }
}
