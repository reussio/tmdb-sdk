package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Date range for now playing movies.
 *
 * @property maximum maximum release date
 * @property minimum minimum release date
 */
@JvmRecord
data class MovieNowPlayingDates(
    @all:JsonProperty("maximum")
    val maximum: String?,
    @all:JsonProperty("minimum")
    val minimum: String?,
) : TmdbModel
