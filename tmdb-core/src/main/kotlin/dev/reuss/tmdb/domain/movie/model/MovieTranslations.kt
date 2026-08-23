package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse

/**
 * Translations for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property translations movie translations
 */
@JvmRecord
data class MovieTranslations(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("translations")
    override val translations: List<Translation<MovieTranslationData>> = emptyList()
) : TranslationsResponse<MovieTranslationData>, TmdbModel
