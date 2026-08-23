package dev.reuss.tmdb.value.image.size

/** Profile-image size values exposed by [dev.reuss.tmdb.domain.images.url.ImageUrlBuilder]. */
enum class ProfileSize(
    override val value: String,
) : ImageSize {
    W45("w45"),
    W185("w185"),
    H632("h632"),
    ORIGINAL("original"),
}
