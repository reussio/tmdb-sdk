package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.common.keyword.KeywordsResponse

/**
 * Keywords for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property keywords movie keywords
 */
@JvmRecord
data class MovieKeywords(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("keywords")
    override val keywords: List<Keyword> = emptyList()
) : KeywordsResponse, TmdbModel
