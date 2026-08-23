package dev.reuss.tmdb.common.translation

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Translation metadata and endpoint-specific translated data.
 *
 * @property iso31661    ISO 3166-1 region code
 * @property iso6391     ISO 639-1 language code
 * @property name        localized language name
 * @property englishName English language name
 * @property data        endpoint-specific translated data
 * @property <T>         translated data type
 */
@JvmRecord
data class Translation<T>(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,
    @all:JsonProperty("iso_639_1")
    val iso6391: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("english_name")
    val englishName: String?,
    @all:JsonProperty("data")
    val data: T?,
) : TmdbModel
