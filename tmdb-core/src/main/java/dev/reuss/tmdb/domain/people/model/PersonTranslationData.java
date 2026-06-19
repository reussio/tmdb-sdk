package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Translated TMDB person data.
 *
 * @param biography translated biography
 * @param name      translated person name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonTranslationData(
        String biography,
        String name
) implements TmdbModel {
}