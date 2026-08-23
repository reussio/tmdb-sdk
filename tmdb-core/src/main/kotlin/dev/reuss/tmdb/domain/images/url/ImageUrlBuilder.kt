package dev.reuss.tmdb.domain.images.url

import dev.reuss.tmdb.value.image.size.BackdropSize
import dev.reuss.tmdb.value.image.size.LogoSize
import dev.reuss.tmdb.value.image.size.PosterSize
import dev.reuss.tmdb.value.image.size.ProfileSize
import dev.reuss.tmdb.value.image.size.StillSize
import java.net.URI

/**
 * Service for creating TMDB image URLs.
 *
 * TMDB exposes image paths in many API responses. This service combines
 * those paths with the configured TMDB image base URL and a requested size.
 */
interface ImageUrlBuilder {
    fun poster(
        path: String,
        size: PosterSize,
    ): URI

    fun backdrop(
        path: String,
        size: BackdropSize,
    ): URI

    fun logo(
        path: String,
        size: LogoSize,
    ): URI

    fun profile(
        path: String,
        size: ProfileSize,
    ): URI

    fun still(
        path: String,
        size: StillSize,
    ): URI
}
