package dev.reuss.tmdb.value.image.size

/**
 * Size segment used when constructing a TMDB image URL.
 */
interface ImageSize {
    /** Wire value inserted between the image base URL and file path. */
    val value: String
}
