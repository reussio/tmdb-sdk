package dev.reuss.tmdb.value.image.size

enum class LogoSize(
    override val value: String
) : ImageSize {
    W45("w45"),
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W300("w300"),
    W500("w500"),
    ORIGINAL("original")
}