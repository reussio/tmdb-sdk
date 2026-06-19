package dev.reuss.tmdb.domain.trending;


import dev.reuss.tmdb.domain.trending.model.TrendingTimeWindow;

final class TrendingPaths {

    private static final String TRENDING = "/trending";

    private TrendingPaths() {
    }

    static String movies(TrendingTimeWindow timeWindow) {
        return TRENDING + "/movie/" + timeWindow.value();
    }

    static String tvShows(TrendingTimeWindow timeWindow) {
        return TRENDING + "/tv/" + timeWindow.value();
    }

    static String people(TrendingTimeWindow timeWindow) {
        return TRENDING + "/person/" + timeWindow.value();
    }

    static String all(TrendingTimeWindow timeWindow) {
        return TRENDING + "/all/" + timeWindow.value();
    }
}
