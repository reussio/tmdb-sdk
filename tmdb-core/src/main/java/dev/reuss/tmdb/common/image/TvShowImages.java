package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB TV show.
 *
 * @param id        TV show id
 * @param backdrops backdrop images
 * @param logos     logo images
 * @param posters   poster images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvShowImages(
        int id,
        List<TmdbImage> backdrops,
        List<TmdbImage> logos,
        List<TmdbImage> posters
) implements TmdbModel {

    public TvShowImages {
        backdrops = TmdbCollections.list(backdrops);
        logos = TmdbCollections.list(logos);
        posters = TmdbCollections.list(posters);
    }
}
