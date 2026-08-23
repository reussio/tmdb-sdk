package dev.reuss.tmdb.domain.configuration.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Timezones used by a TMDB country.
 *
 * @property iso31661 TMDB country code
 * @property zones timezone identifiers
 */
@JvmRecord
data class Timezone(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,

    @all:JsonProperty("zones")
    val zones: List<String> = emptyList()
) : TmdbModel