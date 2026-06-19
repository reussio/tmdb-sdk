package dev.reuss.tmdb.value.image.size;

/**
 * Supported TMDB backdrop image sizes.
 */
public enum BackdropSize implements ImageSize {
    W300("w300"),
    W780("w780"),
    W1280("w1280"),
    ORIGINAL("original");

    private final String value;

    BackdropSize(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
