package dev.reuss.tmdb.domain.networks.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB network details.
 *
 * @property headquarters network headquarters
 * @property homepage network homepage URL
 * @property id TMDB network id
 * @property logoPath TMDB logo image path
 * @property name network name
 * @property originCountry origin country code
 */
@JvmRecord
data class Network(
    @all:JsonProperty("headquarters")
    val headquarters: String?,

    @all:JsonProperty("homepage")
    val homepage: String?,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("logo_path")
    val logoPath: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("origin_country")
    val originCountry: String?
) : TmdbModel