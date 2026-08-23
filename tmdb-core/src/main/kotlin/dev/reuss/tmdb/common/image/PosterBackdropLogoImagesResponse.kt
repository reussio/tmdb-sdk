package dev.reuss.tmdb.common.image

/**
 * Common contract for TMDB image responses that contain backdrops, logos and posters.
 */
interface PosterBackdropLogoImagesResponse {
    val backdrops: List<TmdbImage>

    val logos: List<TmdbImage>

    val posters: List<TmdbImage>

    fun isEmpty(): Boolean =
        backdrops.isEmpty() &&
            logos.isEmpty() &&
            posters.isEmpty()

    fun hasImages(): Boolean = !isEmpty()

    fun hasBackdrops(): Boolean = backdrops.isNotEmpty()

    fun hasLogos(): Boolean = logos.isNotEmpty()

    fun hasPosters(): Boolean = posters.isNotEmpty()

    fun backdropCount(): Int = backdrops.size

    fun logoCount(): Int = logos.size

    fun posterCount(): Int = posters.size

    fun imageCount(): Int = backdrops.size + logos.size + posters.size
}
