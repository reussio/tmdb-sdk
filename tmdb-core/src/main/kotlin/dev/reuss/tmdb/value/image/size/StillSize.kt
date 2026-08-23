package dev.reuss.tmdb.value.image.size

/** Episode-still size values exposed by [dev.reuss.tmdb.domain.images.url.ImageUrlBuilder]. */
enum class StillSize(
    override val value: String,
) : ImageSize {
    W92("w92"),
    W185("w185"),
    W300("w300"),
    ORIGINAL("original"),
}
