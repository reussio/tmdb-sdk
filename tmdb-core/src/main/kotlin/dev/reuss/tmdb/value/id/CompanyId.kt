package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB company resource.
 */
class CompanyId private constructor(
    value: Int,
) : NumericTmdbResourceId(value, "Company id") {
    companion object {
        /**
         * Creates an identifier from a positive TMDB resource ID.
         *
         * @throws IllegalArgumentException if [value] is not greater than `0`
         */
        @JvmStatic
        fun of(value: Int): CompanyId = CompanyId(value)
    }
}
