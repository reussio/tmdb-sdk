package dev.reuss.tmdb.domain.companies.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB company details.
 *
 * @property description   company description
 * @property headquarters  company headquarters
 * @property homepage      company homepage URL
 * @property id            TMDB company id
 * @property logoPath      TMDB logo image path
 * @property name          company name
 * @property originCountry origin country code
 * @property parentCompany parent company information, if available
 */
@JvmRecord
data class Company(
    @all:JsonProperty("description")
    val description: String?,

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
    val originCountry: String?,

    @all:JsonProperty("parent_company")
    val parentCompany: Company?
) : TmdbModel
