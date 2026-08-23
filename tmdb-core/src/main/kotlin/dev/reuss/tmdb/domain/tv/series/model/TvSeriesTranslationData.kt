package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Translated TV series data.
 *
 * @property name translated TV series name
 * @property overview translated overview
 * @property homepage translated homepage
 * @property tagline translated tagline
 */
@JvmRecord
data class TvSeriesTranslationData(
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("homepage")
    val homepage: String?,
    @all:JsonProperty("tagline")
    val tagline: String?,
) : TmdbModel
