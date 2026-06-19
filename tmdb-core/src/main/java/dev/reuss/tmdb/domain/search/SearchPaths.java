package dev.reuss.tmdb.domain.search;

final class SearchPaths {

    private static final String SEARCH = "/search";

    private SearchPaths() {
    }

    static String companies() {
        return SEARCH + "/company";
    }

    static String collections() {
        return SEARCH + "/collection";
    }

    static String keywords() {
        return SEARCH + "/keyword";
    }

    static String movies() {
        return SEARCH + "/movie";
    }

    static String multi() {
        return SEARCH + "/multi";
    }

    static String people() {
        return SEARCH + "/person";
    }

    static String tvShows() {
        return SEARCH + "/tv";
    }
}