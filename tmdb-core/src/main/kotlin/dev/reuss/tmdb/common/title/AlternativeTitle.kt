package dev.reuss.tmdb.common.title

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Alternative title for a TMDB resource.
 *
 * @property iso31661 ISO 3166-1 country or region code
 * @property title    alternative title
 * @property type     alternative title type
 */
@JvmRecord
data class AlternativeTitle(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,

    @all:JsonProperty("title")
    val title: String?,

    @all:JsonProperty("type")
    val type: String?
) : TmdbModel
