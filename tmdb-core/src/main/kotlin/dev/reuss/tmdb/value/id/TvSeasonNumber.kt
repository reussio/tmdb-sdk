package dev.reuss.tmdb.value.id

/**
 * TV season number.
 *
 * @property value season number
 */
data class TvSeasonNumber private constructor(
    val value: Int
) {

    init {
        require(value >= 0) {
            "TV season number must not be negative"
        }
    }

    fun asString(): String = value.toString()

    override fun toString(): String = asString()

    companion object {
        @JvmStatic
        fun of(value: Int): TvSeasonNumber = TvSeasonNumber(value)
    }
}