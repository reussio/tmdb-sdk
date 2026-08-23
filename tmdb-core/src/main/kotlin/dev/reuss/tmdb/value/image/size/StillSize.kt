package dev.reuss.tmdb.value.image.size

enum class StillSize(
    override val value: String
) : ImageSize {
    W92("w92"),
    W185("w185"),
    W300("w300"),
    ORIGINAL("original")
}