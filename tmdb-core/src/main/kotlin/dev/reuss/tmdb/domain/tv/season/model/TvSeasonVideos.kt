package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.video.VideosResponse

/**
 * Videos for a TMDB TV season.
 *
 * @property id TMDB season id
 * @property results TV season videos
 */
@JvmRecord
data class TvSeasonVideos(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    override val results: List<TvSeasonVideo> = emptyList(),
) : VideosResponse<TvSeasonVideo>,
    TmdbModel
