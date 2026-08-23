package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV episode that has screened theatrically.
 *
 * @property id TMDB episode id
 * @property episodeNumber episode number
 * @property seasonNumber season number
 */
@JvmRecord
data class TvSeriesScreenedTheatricallyEpisode(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("episode_number")
    val episodeNumber: Int,

    @all:JsonProperty("season_number")
    val seasonNumber: Int
) : TmdbModel