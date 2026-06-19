package dev.reuss.tmdb.domain.watchproviders;

final class WatchProviderPaths {

    private static final String WATCH_PROVIDER = "/watch/providers";

    private WatchProviderPaths() {
    }

    static String availableRegions() {
        return WATCH_PROVIDER + "/regions";
    }

    static String movieProviders() {
        return WATCH_PROVIDER + "/movie";
    }

    static String tvProviders() {
        return WATCH_PROVIDER + "/tv";
    }
}