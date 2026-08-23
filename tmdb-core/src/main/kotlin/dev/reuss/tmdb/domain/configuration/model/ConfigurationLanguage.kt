package dev.reuss.tmdb.domain.configuration.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Language metadata used throughout TMDB.
 *
 * @property iso6391 ISO 639-1 language code
 * @property englishName English language name
 * @property name native language name
 */
@JvmRecord
data class ConfigurationLanguage(
    @all:JsonProperty("iso_639_1")
    val iso6391: String?,

    @all:JsonProperty("english_name")
    val englishName: String?,

    @all:JsonProperty("name")
    val name: String?
) : TmdbModel