package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Image metadata for a TMDB TV season.
 *
 * @property id      TMDB TV season id
 * @property posters season poster images
 */
@JvmRecord
data class TvSeasonImages(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("posters")
    val posters: List<TmdbImage>?
) : TmdbModel
