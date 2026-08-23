package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Release dates for a specific country.
 *
 * @property iso31661 ISO 3166-1 country code
 * @property releaseDates release dates
 */
@JvmRecord
data class MovieReleaseDateRegion(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,

    @all:JsonProperty("release_dates")
    val releaseDates: List<MovieReleaseDate> = emptyList()
) : TmdbModel