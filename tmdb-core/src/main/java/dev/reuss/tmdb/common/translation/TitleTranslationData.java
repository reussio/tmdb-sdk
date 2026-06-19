package dev.reuss.tmdb.common.translation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Translated title/name data with overview text.
 *
 * @param name     translated name
 * @param overview translated overview
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TitleTranslationData(
        String name,
        String overview
) implements TmdbModel {
}
