package dev.reuss.tmdb.domain.collection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.translation.Translation;
import dev.reuss.tmdb.common.translation.TranslationsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Translations for a TMDB collection.
 *
 * @param id           collection id
 * @param translations collection translations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CollectionTranslations(
        int id,
        List<Translation<CollectionTranslationData>> translations
) implements TranslationsResponse<CollectionTranslationData> {

    public CollectionTranslations {
        translations = TmdbCollections.list(translations);
    }
}
