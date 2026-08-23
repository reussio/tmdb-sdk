package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB company resource.
 */
class CompanyId private constructor(
    value: Int
) : NumericTmdbResourceId(value, "Company id") {

    companion object {
        @JvmStatic
        fun of(value: Int): CompanyId = CompanyId(value)
    }
}