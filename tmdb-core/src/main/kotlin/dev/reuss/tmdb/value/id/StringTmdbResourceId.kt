package dev.reuss.tmdb.value.id

/**
 * Base for type-safe TMDB identifiers represented by opaque strings.
 *
 * Values are trimmed and must not be blank. Equality requires both the same
 * concrete identifier type and the same normalized value.
 */
abstract class StringTmdbResourceId(
    value: String,
    resourceName: String,
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
            (
                other is StringTmdbResourceId &&
                    this::class == other::class &&
                    value == other.value
            )

    final override fun hashCode(): Int = value.hashCode()
}
