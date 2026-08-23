package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Spoken language used in TV series details.
 *
 * @property englishName English language name
 * @property iso6391 ISO 639-1 language code
 * @property name localized language name
 */
@JvmRecord
data class TvSeriesSpokenLanguage(
    @all:JsonProperty("english_name")
    val englishName: String?,

    @all:JsonProperty("iso_639_1")
    val iso6391: String?,

    @all:JsonProperty("name")
    val name: String?
) : TmdbModel