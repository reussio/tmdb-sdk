package dev.reuss.tmdb.domain.discover;

final class DiscoverPaths {

    private static final String DISCOVER = "/discover";

    private DiscoverPaths() {
    }

    static String movies() {
        return DISCOVER + "/movie";
    }

    static String tvSeries() {
        return DISCOVER + "/tv";
    }
}
