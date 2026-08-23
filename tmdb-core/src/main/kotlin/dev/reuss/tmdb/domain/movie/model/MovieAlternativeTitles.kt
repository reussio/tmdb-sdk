package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.title.AlternativeTitle
import dev.reuss.tmdb.common.title.AlternativeTitlesResponse

/**
 * Alternative titles for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property alternativeTitles alternative titles
 */
@JvmRecord
data class MovieAlternativeTitles(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("titles")
    override val alternativeTitles: List<AlternativeTitle> = emptyList()
) : AlternativeTitlesResponse, TmdbModel