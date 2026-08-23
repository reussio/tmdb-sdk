package dev.reuss.tmdb.domain.watchproviders.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Region with available TMDB watch provider data.
 *
 * @property iso31661 ISO 3166-1 region code
 * @property englishName English region name
 * @property nativeName native region name
 */
@JvmRecord
data class WatchProviderRegion(
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,

    @all:JsonProperty("english_name")
    val englishName: String?,

    @all:JsonProperty("native_name")
    val nativeName: String?
) : TmdbModel