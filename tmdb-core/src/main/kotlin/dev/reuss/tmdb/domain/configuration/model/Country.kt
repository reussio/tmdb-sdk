package dev.reuss.tmdb.domain.configuration.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Country metadata used throughout TMDB.
 *
 * @property iso31661 TMDB country code
 * @property englishName English country name
 * @property nativeName native country name
 */
@JvmRecord
data class Country(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,
    @all:JsonProperty("english_name")
    val englishName: String?,
    @all:JsonProperty("native_name")
    val nativeName: String?,
) : TmdbModel
