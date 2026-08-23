package dev.reuss.tmdb.value.id

/**
 * Base for type-safe TMDB identifiers represented by positive integers.
 *
 * Equality requires both the same concrete identifier type and the same value;
 * IDs belonging to different TMDB resource types are never equal.
 */
abstract class NumericTmdbResourceId(
    val value: Int,
    resourceName: String,
) : TmdbResourceId {
    init {
        require(value > 0) {
            "$resourceName must be greater than 0"
        }
    }

    final override fun asString(): String = value.toString()

    final override fun toString(): String = asString()

    final override fun equals(other: Any?): Boolean =
        this === other || (other is NumericTmdbResourceId && this::class == other::class && value == other.value)

    final override fun hashCode(): Int = value
}
