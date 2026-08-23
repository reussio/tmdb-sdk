package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse

/**
 * Translations for a TMDB person.
 *
 * @property id TMDB person id
 * @property translations person translations
 */
@JvmRecord
data class PersonTranslations(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("translations")
    override val translations: List<Translation<PersonTranslationData>> = emptyList()
) : TranslationsResponse<PersonTranslationData>, TmdbModel
