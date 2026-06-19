package dev.reuss.tmdb.domain.movie;

import dev.reuss.tmdb.value.id.MovieId;

final class MoviePaths {

    private static final String MOVIE = "/movie";

    private MoviePaths() {
    }

    static String details(MovieId movieId) {
        return movie(movieId);
    }

    static String alternativeTitles(MovieId movieId) {
        return movie(movieId) + "/alternative_titles";
    }

    static String changes(MovieId movieId) {
        return movie(movieId) + "/changes";
    }

    static String credits(MovieId movieId) {
        return movie(movieId) + "/credits";
    }

    static String externalIds(MovieId movieId) {
        return movie(movieId) + "/external_ids";
    }

    static String images(MovieId movieId) {
        return movie(movieId) + "/images";
    }

    static String keywords(MovieId movieId) {
        return movie(movieId) + "/keywords";
    }

    static String recommendations(MovieId movieId) {
        return movie(movieId) + "/recommendations";
    }

    static String releaseDates(MovieId movieId) {
        return movie(movieId) + "/release_dates";
    }

    static String reviews(MovieId movieId) {
        return movie(movieId) + "/reviews";
    }

    static String similar(MovieId movieId) {
        return movie(movieId) + "/similar";
    }

    static String translations(MovieId movieId) {
        return movie(movieId) + "/translations";
    }

    static String videos(MovieId movieId) {
        return movie(movieId) + "/videos";
    }

    static String watchProviders(MovieId movieId) {
        return movie(movieId) + "/watch/providers";
    }

    static String latest() {
        return MOVIE + "/latest";
    }

    static String nowPlaying() {
        return MOVIE + "/now_playing";
    }

    static String popular() {
        return MOVIE + "/popular";
    }

    static String topRated() {
        return MOVIE + "/top_rated";
    }

    static String upcoming() {
        return MOVIE + "/upcoming";
    }

    private static String movie(MovieId movieId) {
        return MOVIE + "/" + movieId.asString();
    }
}