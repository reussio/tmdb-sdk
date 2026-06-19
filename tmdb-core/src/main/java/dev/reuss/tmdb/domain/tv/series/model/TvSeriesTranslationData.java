package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Translated TV series data.
 *
 * @param name     translated TV series name
 * @param overview translated overview
 * @param homepage translated homepage
 * @param tagline  translated tagline
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesTranslationData(
        String name,
        String overview,
        String homepage,
        String tagline
) implements TmdbModel {
}