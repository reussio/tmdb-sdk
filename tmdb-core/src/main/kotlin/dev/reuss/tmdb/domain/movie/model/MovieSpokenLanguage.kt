package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Spoken language of a movie.
 *
 * @property englishName English language name
 * @property iso6391 ISO 639-1 language code
 * @property name native language name
 */
@JvmRecord
data class MovieSpokenLanguage(
    @all:JsonProperty("english_name")
    val englishName: String?,

    @all:JsonProperty("iso_639_1")
    val iso6391: String?,

    @all:JsonProperty("name")
    val name: String?
) : TmdbModel