package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Image metadata for a TMDB person.
 *
 * @property id       TMDB person id
 * @property profiles profile images
 */
@JvmRecord
data class PersonImages(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("profiles")
    val profiles: List<TmdbImage> = emptyList(),
) : TmdbModel
