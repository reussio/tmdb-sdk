package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV network used in TV series details.
 *
 * @property id TMDB network id
 * @property logoPath logo image path
 * @property name network name
 * @property originCountry origin country code
 */
@JvmRecord
data class TvSeriesNetwork(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("logo_path")
    val logoPath: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("origin_country")
    val originCountry: String?
) : TmdbModel