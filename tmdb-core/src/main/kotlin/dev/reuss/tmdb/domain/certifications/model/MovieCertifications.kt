package dev.reuss.tmdb.domain.certifications.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Supported TMDB movie certifications grouped by region.
 *
 * @property certifications movie certifications grouped by region code
 */
@JvmRecord
data class MovieCertifications(
    @all:JsonProperty("certifications")
    val certifications: Map<String, List<Certification>> = emptyMap()
) : TmdbModel
