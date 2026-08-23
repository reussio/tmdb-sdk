package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Content rating for a TMDB TV series.
 *
 * @property descriptors rating descriptors
 * @property iso31661 ISO 3166-1 region code
 * @property rating content rating
 */
@JvmRecord
data class TvSeriesContentRating(
    @all:JsonProperty("descriptors")
    val descriptors: List<String> = emptyList(),

    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,

    @all:JsonProperty("rating")
    val rating: String?
) : TmdbModel