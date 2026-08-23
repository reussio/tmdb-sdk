package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.title.AlternativeTitle
import dev.reuss.tmdb.common.title.AlternativeTitlesResponse

/**
 * Alternative titles for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property alternativeTitles alternative titles
 */
@JvmRecord
data class TvSeriesAlternativeTitles(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("results")
    override val alternativeTitles: List<AlternativeTitle> = emptyList()
) : AlternativeTitlesResponse, TmdbModel