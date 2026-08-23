package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse

/**
 * Translations for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property translations TV series translations
 */
@JvmRecord
data class TvSeriesTranslations(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("translations")
    override val translations: List<Translation<TvSeriesTranslationData>> = emptyList(),
) : TranslationsResponse<TvSeriesTranslationData>,
    TmdbModel
