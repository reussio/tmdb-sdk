package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB movie.
 *
 * @param id        TMDB movie id
 * @param backdrops backdrop images
 * @param logos     logo images
 * @param posters   poster images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieImages(
        int id,
        List<TmdbImage> backdrops,
        List<TmdbImage> logos,
        List<TmdbImage> posters
) implements PosterBackdropLogoImagesResponse, TmdbModel {

    public MovieImages {
        backdrops = TmdbCollections.list(backdrops);
        logos = TmdbCollections.list(logos);
        posters = TmdbCollections.list(posters);
    }
}
