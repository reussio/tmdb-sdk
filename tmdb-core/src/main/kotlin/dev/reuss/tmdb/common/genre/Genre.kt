package dev.reuss.tmdb.common.genre

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB genre.
 *
 * @property id   TMDB genre id
 * @property name localized genre name
 */
@JvmRecord
data class Genre(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
) : TmdbModel
