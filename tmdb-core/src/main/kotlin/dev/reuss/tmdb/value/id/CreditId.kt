package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB credit resource.
 *
 * TMDB credit ids are string values.
 *
 * @property value the raw TMDB credit id
 */
class CreditId private constructor(
    value: String
) : StringTmdbResourceId(value, "Credit id") {

    companion object {
        @JvmStatic
        fun of(value: String): CreditId = CreditId(value)
    }
}