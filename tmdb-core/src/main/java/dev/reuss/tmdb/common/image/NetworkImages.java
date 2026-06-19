package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB network.
 *
 * @param id    TMDB network id
 * @param logos network logo images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NetworkImages(
        int id,
        List<LogoImage> logos
) implements TmdbModel {

    public NetworkImages {
        logos = TmdbCollections.list(logos);
    }
}