package dev.reuss.tmdb.common.image

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Image metadata for a TMDB network.
 *
 * @property id    TMDB network id
 * @property logos network logo images
 */
@JvmRecord
data class NetworkImages(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("logos")
    override val logos: List<LogoImage> = emptyList()
) : LogoImagesResponse, TmdbModel