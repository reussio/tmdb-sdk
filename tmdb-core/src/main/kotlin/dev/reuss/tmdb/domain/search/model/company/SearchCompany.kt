package dev.reuss.tmdb.domain.search.model.company

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Company returned by TMDB company search.
 *
 * @property id TMDB company id
 * @property logoPath company logo image path
 * @property name company name
 * @property originCountry origin country code
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
    val originCountry: String?
) : TmdbModel