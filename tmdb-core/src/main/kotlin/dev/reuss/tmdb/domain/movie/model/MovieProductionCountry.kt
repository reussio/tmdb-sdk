package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Movie production country.
 *
 * @property iso31661 ISO 3166-1 country code
 * @property name country name
 */
@JvmRecord
data class MovieProductionCountry(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,

    @all:JsonProperty("name")
    val name: String?
) : TmdbModel