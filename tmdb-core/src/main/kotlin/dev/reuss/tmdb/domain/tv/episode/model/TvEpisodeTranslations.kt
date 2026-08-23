package dev.reuss.tmdb.domain.tv.episode.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.translation.TitleTranslationData
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse

/**
 * Translations for a TMDB TV episode.
 *
 * @property id TMDB episode id
 * @property translations TV episode translations
 */
@JvmRecord
data class TvEpisodeTranslations(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("translations")
    override val translations: List<Translation<TitleTranslationData>> = emptyList(),
) : TranslationsResponse<TitleTranslationData>,
    TmdbModel
