package dev.reuss.tmdb.domain.collection.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse

/**
 * Translations for a TMDB collection.
 *
 * @property id collection id
 * @property translations collection translations
 */
@JvmRecord
data class CollectionTranslations(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("translations")
    override val translations: List<Translation<CollectionTranslationData>> = emptyList(),
) : TranslationsResponse<CollectionTranslationData>,
    TmdbModel
