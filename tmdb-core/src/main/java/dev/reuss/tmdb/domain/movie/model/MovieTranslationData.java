package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Translated movie data.
 *
 * @param homepage translated homepage
 * @param overview translated overview
 * @param runtime  localized runtime
 * @param tagline  translated tagline
 * @param title    translated title
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieTranslationData(
        String homepage,
        String overview,
        Integer runtime,
        String tagline,
        String title
) implements TmdbModel {
}
