package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Image metadata for a TMDB company.
 *
 * @param id    TMDB company id
 * @param logos company logo images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CompanyImages(
        int id,
        List<LogoImage> logos
) implements LogoImagesResponse, TmdbModel {
    public CompanyImages {
        logos = TmdbCollections.list(logos);
    }
}