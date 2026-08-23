package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Represents logo image metadata returned by TMDB.
 *
 * @property aspectRatio logo aspect ratio
 * @property filePath    TMDB image file path
 * @property height      logo height in pixels
 * @property id          TMDB image id
 * @property fileType    original logo file type, for example {@code .svg} or {@code .png}
 * @property voteAverage average image vote
 * @property voteCount   image vote count
 * @property width       logo width in pixels
 */
@JvmRecord
data class LogoImage(
    @all:JsonProperty("aspect_ratio")
    val aspectRatio: Double,
    @all:JsonProperty("file_path")
    val filePath: String?,
    @all:JsonProperty("height")
    val height: Int,
    @all:JsonProperty("id")
    val id: String?,
    @all:JsonProperty("file_type")
    val fileType: String?,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("vote_count")
    val voteCount: Int,
    @all:JsonProperty("width")
    val width: Int,
) : TmdbModel
