package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.video.VideosResponse

/**
 * Videos for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property results movie videos
 */
@JvmRecord
data class MovieVideos(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    override val results: List<MovieVideo> = emptyList(),
) : VideosResponse<MovieVideo>,
    TmdbModel
