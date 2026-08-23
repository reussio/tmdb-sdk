package dev.reuss.tmdb.domain.search.model.company

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Company returned by TMDB company search.
 *
 * @property id TMDB company id
 * @property logoPath TMDB image path for the logo.
 * @property name company name
 * @property originCountry ISO 3166-1 code for the resource's country of origin.
 */
@JvmRecord
data class SearchCompany(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("logo_path")
    val logoPath: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("origin_country")
    val originCountry: String?,
) : TmdbModel
