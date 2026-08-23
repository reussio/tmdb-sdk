package dev.reuss.tmdb.domain.companies.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.name.AlternativeNamesResponse

/**
 * Alternative names for a TMDB company.
 *
 * @property id      TMDB company id
 * @property results alternative company names
 */

data class CompanyAlternativeNames(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("results")
    override val results: List<CompanyAlternativeName> = emptyList()
) : AlternativeNamesResponse<CompanyAlternativeName>, TmdbModel