package dev.reuss.tmdb.common.image

/**
 * Common contract for TMDB image responses that contain logo images.
 */
interface LogoImagesResponse {

    val logos: List<LogoImage>

    fun isEmpty(): Boolean =
        logos.isEmpty()

    fun hasLogos(): Boolean =
        logos.isNotEmpty()

    fun logoCount(): Int =
        logos.size
}