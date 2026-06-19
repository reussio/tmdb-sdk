package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.translation.TitleTranslationData;
import dev.reuss.tmdb.common.translation.Translation;
import dev.reuss.tmdb.common.translation.TranslationsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Translations for a TMDB TV season.
 *
 * @param id           TMDB season id
 * @param translations TV season translations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonTranslations(
        int id,
        List<Translation<TitleTranslationData>> translations
) implements TranslationsResponse<TitleTranslationData>, TmdbModel {

    public TvSeasonTranslations {
        translations = TmdbCollections.list(translations);
    }
}
