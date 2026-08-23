package dev.reuss.tmdb.domain.tv.episode.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.video.VideosResponse

/**
 * Videos for a TMDB TV episode.
 *
 * @property id TMDB episode id
 * @property results TV episode videos
 */
@JvmRecord
data class TvEpisodeVideos(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    override val results: List<TvEpisodeVideo> = emptyList(),
) : VideosResponse<TvEpisodeVideo>,
    TmdbModel
