package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Image metadata for a TMDB TV episode.
 *
 * @property id     TMDB TV episode id
 * @property stills episode still images
 */
@JvmRecord
data class TvEpisodeImages(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("stills")
    val stills: List<TmdbImage> = emptyList(),
) : TmdbModel
