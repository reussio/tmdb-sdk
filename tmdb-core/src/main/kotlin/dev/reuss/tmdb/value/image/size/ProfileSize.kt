package dev.reuss.tmdb.value.image.size

enum class ProfileSize(
    override val value: String,
) : ImageSize {
    W45("w45"),
    W185("w185"),
    H632("h632"),
    ORIGINAL("original"),
}
