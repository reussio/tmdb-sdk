package dev.reuss.tmdb.value.image.size

/** Backdrop size values exposed by [dev.reuss.tmdb.domain.images.url.ImageUrlBuilder]. */
enum class BackdropSize(
    override val value: String,
) : ImageSize {
    W300("w300"),
    W780("w780"),
    W1280("w1280"),
    ORIGINAL("original"),
}
