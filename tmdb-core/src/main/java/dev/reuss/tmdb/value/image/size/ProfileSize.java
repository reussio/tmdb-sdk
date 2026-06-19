package dev.reuss.tmdb.value.image.size;

/**
 * Supported TMDB profile image sizes.
 */
public enum ProfileSize implements ImageSize {
    W45("w45"),
    W185("w185"),
    H632("h632"),
    ORIGINAL("original");

    private final String value;

    ProfileSize(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
