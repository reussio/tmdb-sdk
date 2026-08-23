package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Translated TMDB person data.
 *
 * @property biography translated biography
 * @property name translated person name
 */
@JvmRecord
data class PersonTranslationData(
    @all:JsonProperty("biography")
    val biography: String?,
    @all:JsonProperty("name")
    val name: String?,
) : TmdbModel
