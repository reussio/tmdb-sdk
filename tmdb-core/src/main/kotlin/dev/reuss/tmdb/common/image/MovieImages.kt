package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Image metadata for a TMDB movie.
 *
 * @property id        TMDB movie id
 * @property backdrops backdrop images
 * @property logos     logo images
 * @property posters   poster images
 */
@JvmRecord
data class MovieImages(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("backdrops")
    override val backdrops: List<TmdbImage> = emptyList(),
    @all:JsonProperty("logos")
    override val logos: List<TmdbImage> = emptyList(),
    @all:JsonProperty("posters")
    override val posters: List<TmdbImage> = emptyList(),
) : PosterBackdropLogoImagesResponse,
    TmdbModel
