package dev.reuss.tmdb.domain.certifications.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Represents a TMDB certification entry.
 *
 * @property certification certification value, for example {@code 12}, {@code PG-13} or {@code R}
 * @property meaning       certification meaning
 * @property order         display or severity order
 */
@JvmRecord
data class Certification(
    @all:JsonProperty("certification")
    val certification: String?,
    @all:JsonProperty("meaning")
    val meaning: String?,
    @all:JsonProperty("order")
    val order: Int,
) : TmdbModel
