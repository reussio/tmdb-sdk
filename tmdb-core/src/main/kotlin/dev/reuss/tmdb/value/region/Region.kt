package dev.reuss.tmdb.value.region

import dev.reuss.tmdb.common.TmdbModel
import java.util.*

/**
 * Represents a TMDB region parameter.
 *
 * TMDB expects regions as
 * [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2)
 * country codes, for example `DE`, `US`, `GB` or `BR`.
 *
 * The region parameter is used by TMDB as a regional filter or
 * presentation hint, for example for release dates, watch providers
 * and discover/search requests.
 *
 * See also the [TMDB region support documentation](https://developer.themoviedb.org/docs/region-support).
 *
 * @property value the ISO 3166-1 alpha-2 region code
 *
 * @see Regions
 */
class Region private constructor(
    val value: String
) : TmdbModel {

    override fun toString(): String = value

    override fun equals(other: Any?): Boolean =
        this === other || other is Region && value == other.value

    override fun hashCode(): Int = value.hashCode()

    companion object {
        private val ISO_COUNTRIES = Locale.getISOCountries().toSet()

        @JvmStatic
        fun of(value: String): Region {
            require(value.isNotBlank()) {
                "Region must not be blank"
            }

            val normalized = value.uppercase(Locale.ROOT)

            require(normalized.matches(Regex("^[A-Z]{2}$"))) {
                "Region must be a two-letter ISO 3166-1 alpha-2 code"
            }

            require(normalized in ISO_COUNTRIES) {
                "Unknown ISO 3166-1 alpha-2 region: $normalized"
            }

            return Region(normalized)
        }
    }
}