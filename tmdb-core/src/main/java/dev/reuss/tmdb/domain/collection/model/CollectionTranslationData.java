package dev.reuss.tmdb.domain.collection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Translated collection data.
 *
 * @param title    translated title
 * @param overview translated overview
 * @param homepage translated homepage
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CollectionTranslationData(
        String title,
        String overview,
        String homepage
) {
}
