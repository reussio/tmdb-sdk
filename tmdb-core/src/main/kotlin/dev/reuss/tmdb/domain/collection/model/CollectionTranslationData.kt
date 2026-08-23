package dev.reuss.tmdb.domain.collection.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Translated collection data.
 *
 * @property title translated title
 * @property overview Localized overview when available.
 * @property homepage translated homepage
 */
@JvmRecord
data class CollectionTranslationData(
    @all:JsonProperty("title")
    val title: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("homepage")
    val homepage: String?,
) : TmdbModel
