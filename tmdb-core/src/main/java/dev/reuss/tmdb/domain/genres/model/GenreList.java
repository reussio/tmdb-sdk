package dev.reuss.tmdb.domain.genres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.genre.Genre;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * List of TMDB genres.
 *
 * @param genres genres
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GenreList(
        List<Genre> genres
) implements TmdbModel {

    public GenreList {
        genres = TmdbCollections.list(genres);
    }
}
