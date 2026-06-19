package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.translation.Translation;
import dev.reuss.tmdb.common.translation.TranslationsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Translations for a TMDB movie.
 *
 * @param id           TMDB movie id
 * @param translations movie translations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieTranslations(
        int id,
        List<Translation<MovieTranslationData>> translations
) implements TranslationsResponse<MovieTranslationData>, TmdbModel {

    public MovieTranslations {
        translations = TmdbCollections.list(translations);
    }
}
