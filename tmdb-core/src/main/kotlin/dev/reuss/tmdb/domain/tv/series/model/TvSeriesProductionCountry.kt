package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Production country used in TV series details.
 *
 * @property iso31661 ISO 3166-1 country code
 * @property name country name
 */
@JvmRecord
data class TvSeriesProductionCountry(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,
    @all:JsonProperty("name")
    val name: String?,
) : TmdbModel
