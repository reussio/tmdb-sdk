package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Collection a movie belongs to.
 *
 * @property id TMDB collection id
 * @property name collection name
 * @property posterPath poster image path
 * @property backdropPath backdrop image path
 */
@JvmRecord
data class MovieCollection(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
) : TmdbModel
