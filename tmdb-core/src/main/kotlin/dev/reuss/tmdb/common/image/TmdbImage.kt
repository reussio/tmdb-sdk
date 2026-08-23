package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Represents image metadata returned by TMDB.
 *
 * @property aspectRatio image aspect ratio
 * @property height      image height in pixels
 * @property iso6391     optional ISO 639-1 language code
 * @property filePath    TMDB image file path
 * @property voteAverage average image vote
 * @property voteCount   image vote count
 * @property width       image width in pixels
 */
@JvmRecord
data class TmdbImage(
    @all:JsonProperty("aspect_ratio")
    val aspectRatio: Double,
    @all:JsonProperty("height")
    val height: Int,
    @all:JsonProperty("iso_639_1")
    val iso6391: String?,
    @all:JsonProperty("file_path")
    val filePath: String?,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("width")
    val width: Int,
) : TmdbModel
