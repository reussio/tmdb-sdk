package dev.reuss.tmdb.value.id

/**
 * Base class for string-based TMDB resource identifiers.
 */
abstract class StringTmdbResourceId(
    value: String,
    resourceName: String
) : TmdbResourceId {

    val value: String

    init {
        require(value.isNotBlank()) {
            "$resourceName must not be blank"
        }

        this.value = value.trim()
    }

    final override fun asString(): String = value

    final override fun toString(): String = value

    final override fun equals(other: Any?): Boolean =
        this === other ||
                other != null &&
                this::class == other::class &&
                other is StringTmdbResourceId &&
                value == other.value

    final override fun hashCode(): Int = value.hashCode()
}