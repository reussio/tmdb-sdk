package dev.reuss.tmdb.domain.companies.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Alternative name for a TMDB company.
 *
 * @property name alternative company name
 * @property type optional name type
 */
@JvmRecord
data class CompanyAlternativeName(
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("type")
    val type: String?,
) : TmdbModel
