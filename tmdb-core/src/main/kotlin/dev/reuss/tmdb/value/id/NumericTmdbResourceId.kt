package dev.reuss.tmdb.value.id

/**
 * Base class for numeric TMDB resource identifiers.
 */
abstract class NumericTmdbResourceId(
    val value: Int,
    resourceName: String
) : TmdbResourceId {

    init {
        require(value > 0) {
            "$resourceName must be greater than 0"
        }
    }

    final override fun asString(): String = value.toString()

    final override fun toString(): String = asString()

    final override fun equals(other: Any?): Boolean =
        this === other ||
                other != null &&
                this::class == other::class &&
                other is NumericTmdbResourceId &&
                value == other.value

    final override fun hashCode(): Int = value
}