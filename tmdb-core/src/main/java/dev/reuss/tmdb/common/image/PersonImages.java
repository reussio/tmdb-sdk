package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB person.
 *
 * @param id       TMDB person id
 * @param profiles profile images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonImages(
        int id,
        List<TmdbImage> profiles
) implements TmdbModel {

    public PersonImages {
        profiles = TmdbCollections.list(profiles);
    }
}