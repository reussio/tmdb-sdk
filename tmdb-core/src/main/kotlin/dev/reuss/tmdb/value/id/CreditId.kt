package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB credit resource.
 *
 * TMDB credit ids are string values.
 *
 * @property value the raw TMDB credit id
 */
class CreditId private constructor(
    value: String,
) : StringTmdbResourceId(value, "Credit id") {
    companion object {
        /**
         * Creates an identifier from a non-blank value.
         *
         * Leading and trailing whitespace is removed.
         *
         * @throws IllegalArgumentException if [value] is blank
         */
        @JvmStatic
        fun of(value: String): CreditId = CreditId(value)
    }
}
