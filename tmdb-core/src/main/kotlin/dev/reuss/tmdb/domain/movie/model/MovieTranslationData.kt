package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Translated movie data.
 *
 * @property homepage translated homepage
 * @property overview Localized overview when available.
 * @property runtime Runtime in minutes when known.
 * @property tagline translated tagline
 * @property title translated title
 */
@JvmRecord
data class MovieTranslationData(
    @all:JsonProperty("homepage")
    val homepage: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("runtime")
    val runtime: Int?,
    @all:JsonProperty("tagline")
    val tagline: String?,
    @all:JsonProperty("title")
    val title: String?,
) : TmdbModel
