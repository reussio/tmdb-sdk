package dev.reuss.tmdb.common.watchprovider

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.domain.watchproviders.model.WatchProvider

/**
 * Watch provider availability for a specific region.
 *
 * @property link     TMDB watch provider link
 * @property flatrate flatrate streaming providers
 * @property rent     rental providers
 * @property buy      purchase providers
 * @property ads      ad-supported providers
 * @property free     free providers
 */
@JvmRecord
data class WatchProviderAvailability(
    @all:JsonProperty("link")
    val link: String?,

    @all:JsonProperty("flatrate")
    val flatrate: List<WatchProvider> = emptyList(),

    @all:JsonProperty("rent")
    val rent: List<WatchProvider> = emptyList(),

    @all:JsonProperty("buy")
    val buy: List<WatchProvider> = emptyList(),

    @all:JsonProperty("ads")
    val ads: List<WatchProvider> = emptyList(),

    @all:JsonProperty("free")
    val free: List<WatchProvider> = emptyList()
) : TmdbModel
