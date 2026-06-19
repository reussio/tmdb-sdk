package dev.reuss.tmdb.value.image.size;

public enum LogoSize implements ImageSize {
    W45("w45"),
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W300("w300"),
    W500("w500"),
    ORIGINAL("original");

    private final String value;

    LogoSize(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
