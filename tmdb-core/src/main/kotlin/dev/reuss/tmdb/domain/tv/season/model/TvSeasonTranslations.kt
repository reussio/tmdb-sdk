package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.translation.TitleTranslationData
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse

/**
 * Translations for a TMDB TV season.
 *
 * @property id TMDB season id
 * @property translations TV season translations
 */
@JvmRecord
data class TvSeasonTranslations(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("translations")
    override val translations: List<Translation<TitleTranslationData>> = emptyList()
) : TranslationsResponse<TitleTranslationData>, TmdbModel
