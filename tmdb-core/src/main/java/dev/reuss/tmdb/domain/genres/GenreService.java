package dev.reuss.tmdb.domain.genres;

import dev.reuss.tmdb.domain.genres.model.GenreList;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for loading TMDB genre metadata.
 */
public interface GenreService {

    /**
     * Loads the official list of movie genres.
     *
     * @return movie genres
     */
    GenreList movies();

    /**
     * Loads the official list of movie genres using a specific language.
     *
     * @param language response language
     * @return localized movie genres
     */
    GenreList movies(Language language);

    /**
     * Loads the official list of TV genres.
     *
     * @return TV genres
     */
    GenreList tv();

    /**
     * Loads the official list of TV genres using a specific language.
     *
     * @param language response language
     * @return localized TV genres
     */
    GenreList tv(Language language);
}