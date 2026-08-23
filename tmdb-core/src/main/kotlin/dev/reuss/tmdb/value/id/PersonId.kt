package dev.reuss.tmdb.value.id

/**
 * Strongly typed identifier for a TMDB person resource.
 */
class PersonId private constructor(
    value: Int
) : NumericTmdbResourceId(value, "Person id") {

    companion object {
        @JvmStatic
        fun of(value: Int): PersonId = PersonId(value)
    }
}