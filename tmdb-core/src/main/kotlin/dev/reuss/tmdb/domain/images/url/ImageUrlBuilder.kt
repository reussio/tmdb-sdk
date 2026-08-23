package dev.reuss.tmdb.domain.images.url

import dev.reuss.tmdb.value.image.size.BackdropSize
import dev.reuss.tmdb.value.image.size.LogoSize
import dev.reuss.tmdb.value.image.size.PosterSize
import dev.reuss.tmdb.value.image.size.ProfileSize
import dev.reuss.tmdb.value.image.size.StillSize
import java.net.URI

/**
 * Builds complete TMDB image URLs from paths returned by the API.
 *
 * TMDB image URLs combine the secure base URL from API configuration, a size,
 * and an image path. Configuration is loaded lazily on the first non-blank path.
 *
 * @throws IllegalArgumentException if an image path is blank
 * @throws IllegalStateException if TMDB configuration has no secure image base URL
 */
interface ImageUrlBuilder {
    /** Builds a poster URL at [size]. */
    fun poster(
        path: String,
        size: PosterSize,
    ): URI

    /** Builds a backdrop URL at [size]. */
    fun backdrop(
        path: String,
        size: BackdropSize,
    ): URI

    /** Builds a logo URL at [size]. */
    fun logo(
        path: String,
        size: LogoSize,
    ): URI

    /** Builds a profile-image URL at [size]. */
    fun profile(
        path: String,
        size: ProfileSize,
    ): URI

    /** Builds an episode-still URL at [size]. */
    fun still(
        path: String,
        size: StillSize,
    ): URI
}
