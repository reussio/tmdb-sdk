package dev.reuss.tmdb.domain.tv.episodegroup.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Network of a TV episode group.
 *
 * @property id TMDB network id
 * @property logoPath network logo path
 * @property name network name
 * @property originCountry origin country
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
    val originCountry: String?
) : TmdbModel