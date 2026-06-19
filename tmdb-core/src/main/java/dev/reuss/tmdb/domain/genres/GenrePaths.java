package dev.reuss.tmdb.domain.genres;

final class GenrePaths {

    private static final String GENRE = "/genre";

    private GenrePaths() {
    }

    static String movieGenres() {
        return GENRE + "/movie/list";
    }

    static String tvSeriesGenres() {
        return GENRE + "/tv/list";
    }
}