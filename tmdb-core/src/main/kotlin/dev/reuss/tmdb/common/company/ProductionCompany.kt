package dev.reuss.tmdb.common.company

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Production company for a TMDB resource.
 *
 * @property id            TMDB company id
 * @property logoPath      company logo path
 * @property name          company name
 * @property originCountry origin country
 */
@JvmRecord
data class ProductionCompany(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("logo_path")
    val logoPath: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("origin_country")
    val originCountry: String?,
) : TmdbModel
