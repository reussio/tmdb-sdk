package dev.reuss.tmdb.value.id

/**
 * TV episode number.
 *
 * @property value episode number
 */
data class TvEpisodeNumber private constructor(
    val value: Int
) {

    init {
        require(value > 0) {
            "TV episode number must be greater than 0"
        }
    }

    fun asString(): String = value.toString()

    override fun toString(): String = asString()

    companion object {
        @JvmStatic
        fun of(value: Int): TvEpisodeNumber = TvEpisodeNumber(value)
    }
}