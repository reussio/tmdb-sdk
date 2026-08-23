package dev.reuss.tmdb.value.id

/**
 * One-based episode number used in TV episode paths.
 *
 * @property value Positive episode number.
 */
data class TvEpisodeNumber private constructor(
    val value: Int,
) {
    init {
        require(value > 0) {
            "TV episode number must be greater than 0"
        }
    }

    fun asString(): String = value.toString()

    override fun toString(): String = asString()

    companion object {
        /**
         * Creates an episode number.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): TvEpisodeNumber = TvEpisodeNumber(value)
    }
}
