package dev.reuss.tmdb.domain.tv.episode.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Video for a TMDB TV episode.
 *
 * @property iso6391 ISO 639-1 language code associated with the value.
 * @property iso31661 ISO 3166-1 country code associated with the value.
 * @property name video name
 * @property key Provider-specific key used to locate the video.
 * @property site Provider hosting the video, such as YouTube.
 * @property size Video resolution reported by TMDB.
 * @property type TMDB video type, such as trailer or teaser.
 * @property official Whether TMDB marks the video as official.
 * @property publishedAt Video publication timestamp.
 * @property id TMDB video id
 */
@JvmRecord
data class TvEpisodeVideo(
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
