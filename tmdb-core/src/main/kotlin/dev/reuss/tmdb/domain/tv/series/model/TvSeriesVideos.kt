package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.video.VideosResponse

/**
 * Videos for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property results TV series videos
 */
@JvmRecord
data class TvSeriesVideos(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    override val results: List<TvSeriesVideo> = emptyList(),
) : VideosResponse<TvSeriesVideo>,
    TmdbModel
