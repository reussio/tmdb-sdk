package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Release dates for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property results release dates grouped by country
 */
@JvmRecord
data class MovieReleaseDates(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    val results: List<MovieReleaseDateRegion> = emptyList(),
) : TmdbModel
