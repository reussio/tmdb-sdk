package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Content ratings for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property results content ratings
 */
@JvmRecord
data class TvSeriesContentRatings(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("results")
    val results: List<TvSeriesContentRating> = emptyList(),
) : TmdbModel
