package dev.reuss.tmdb.domain.trending.model;

/**
 * Time window for TMDB trending requests.
 */
public enum TrendingTimeWindow {
    DAY("day"),
    WEEK("week");

    private final String value;

    TrendingTimeWindow(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}