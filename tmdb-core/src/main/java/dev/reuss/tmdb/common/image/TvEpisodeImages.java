package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB TV episode.
 *
 * @param id     TMDB TV episode id
 * @param stills episode still images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeImages(
        int id,
        List<TmdbImage> stills
) implements TmdbModel {

    public TvEpisodeImages {
        stills = TmdbCollections.list(stills);
    }
}