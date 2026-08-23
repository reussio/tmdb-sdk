package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Video for a TMDB TV season.
 *
 * @property iso6391 ISO 639-1 language code
 * @property iso31661 ISO 3166-1 region code
 * @property name video name
 * @property key video key, for example the YouTube video id
 * @property site video provider site
 * @property size video size
 * @property type video type
 * @property official whether the video is official
 * @property publishedAt publish timestamp
 * @property id TMDB video id
 */
@JvmRecord
data class TvSeasonVideo(
    @all:JsonProperty("iso_639_1")
    val iso6391: String?,
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("key")
    val key: String?,
    @all:JsonProperty("site")
    val site: String?,
    @all:JsonProperty("size")
    val size: Int,
    @all:JsonProperty("type")
    val type: String?,
    @all:JsonProperty("official")
    val official: Boolean,
    @all:JsonProperty("published_at")
    val publishedAt: String?,
    @all:JsonProperty("id")
    val id: String?,
) : TmdbModel
