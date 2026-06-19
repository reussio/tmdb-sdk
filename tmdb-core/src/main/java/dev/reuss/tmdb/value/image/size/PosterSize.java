package dev.reuss.tmdb.value.image.size;

/**
 * Supported TMDB poster image sizes.
 */
public enum PosterSize implements ImageSize {
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W342("w342"),
    W500("w500"),
    W780("w780"),
    ORIGINAL("original");

    private final String value;

    PosterSize(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
