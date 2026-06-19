package dev.reuss.tmdb.domain.genres;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.genres.model.GenreList;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default {@link GenreService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultGenreService implements GenreService {

    private final TmdbHttpClient httpClient;

    public DefaultGenreService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public GenreList movies() {
        return httpClient.get(
                TmdbRequest.get("/genre/movie/list"),
                GenreList.class
        );
    }

    @Override
    public GenreList movies(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        GenrePaths.movieGenres(),
                        QueryParams.create().add("language", language)
                ),
                GenreList.class
        );
    }

    @Override
    public GenreList tv() {
        return httpClient.get(
                TmdbRequest.get("/genre/tv/list"),
                GenreList.class
        );
    }

    @Override
    public GenreList tv(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        GenrePaths.tvSeriesGenres(),
                        QueryParams.create().add("language", language)
                ),
                GenreList.class
        );
    }
}