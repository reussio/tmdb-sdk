package dev.reuss.tmdb.common.translation

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Translated title/name data with overview text.
 *
 * @property name     translated name
 * @property overview Localized overview when available.
 */
@JvmRecord
data class TitleTranslationData(
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
) : TmdbModel
