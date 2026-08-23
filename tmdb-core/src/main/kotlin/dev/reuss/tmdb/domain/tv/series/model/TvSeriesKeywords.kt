package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.common.keyword.KeywordsResponse

/**
 * Keywords for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property keywords TV series keywords
 */
@JvmRecord
data class TvSeriesKeywords(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("results")
    override val keywords: List<Keyword> = emptyList()
) : KeywordsResponse, TmdbModel