package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Network of a TV episode group.
 *
 * @property id TMDB network id
 * @property logoPath TMDB image path for the logo.
 * @property name network name
 * @property originCountry ISO 3166-1 code for the resource's country of origin.
 */
@JvmRecord
data class TvEpisodeGroupNetwork(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("logo_path")
    val logoPath: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("origin_country")
    val originCountry: String?,
) : TmdbModel
