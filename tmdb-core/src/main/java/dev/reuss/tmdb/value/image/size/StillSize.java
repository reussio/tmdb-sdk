package dev.reuss.tmdb.value.image.size;

public enum StillSize implements ImageSize {
    W92("w92"),
    W185("w185"),
    W300("w300"),
    ORIGINAL("original");

    private final String value;

    StillSize(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
