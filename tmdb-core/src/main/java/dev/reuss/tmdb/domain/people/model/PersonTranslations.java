package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.translation.Translation;
import dev.reuss.tmdb.common.translation.TranslationsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Translations for a TMDB person.
 *
 * @param id           TMDB person id
 * @param translations person translations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonTranslations(
        int id,
        List<Translation<PersonTranslationData>> translations
) implements TranslationsResponse<PersonTranslationData>, TmdbModel {

    public PersonTranslations {
        translations = TmdbCollections.list(translations);
    }
}
