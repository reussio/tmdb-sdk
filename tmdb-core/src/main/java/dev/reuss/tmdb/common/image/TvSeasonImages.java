package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB TV season.
 *
 * @param id      TMDB TV season id
 * @param posters season poster images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonImages(
        int id,
        List<TmdbImage> posters
) implements TmdbModel {

    public TvSeasonImages {
        posters = TmdbCollections.list(posters);
    }
}