package dev.reuss.tmdb.domain.tv.episode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.translation.TitleTranslationData;
import dev.reuss.tmdb.common.translation.Translation;
import dev.reuss.tmdb.common.translation.TranslationsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Translations for a TMDB TV episode.
 *
 * @param id           TMDB episode id
 * @param translations TV episode translations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeTranslations(
        int id,
        List<Translation<TitleTranslationData>> translations
) implements TranslationsResponse<TitleTranslationData>, TmdbModel {

    public TvEpisodeTranslations {
        translations = TmdbCollections.list(translations);
    }
}
