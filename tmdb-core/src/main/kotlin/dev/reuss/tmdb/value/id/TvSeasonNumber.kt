package dev.reuss.tmdb.value.id

/**
 * Season number used in TMDB TV season and episode paths.
 *
 * TMDB uses season `0` for specials, so zero is valid while negative values are not.
 *
 * @property value Non-negative season number.
 */
data class TvSeasonNumber private constructor(
    val value: Int,
) {
    init {
        require(value >= 0) {
            "TV season number must not be negative"
        }
    }

    fun asString(): String = value.toString()

    override fun toString(): String = asString()

    companion object {
        /**
         * Creates a season number, including `0` for specials.
         *
         * @throws IllegalArgumentException if [value] is negative
         */
        @JvmStatic
        fun of(value: Int): TvSeasonNumber = TvSeasonNumber(value)
    }
}
