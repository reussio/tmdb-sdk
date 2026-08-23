package dev.reuss.tmdb.common.keyword

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB keyword.
 *
 * @property id   TMDB keyword id
 * @property name keyword name
 */
@JvmRecord
data class Keyword(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
) : TmdbModel
