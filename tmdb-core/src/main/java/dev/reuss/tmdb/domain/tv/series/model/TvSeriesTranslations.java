package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.translation.Translation;
import dev.reuss.tmdb.common.translation.TranslationsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Translations for a TMDB TV series.
 *
 * @param id           TMDB TV series id
 * @param translations TV series translations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesTranslations(
        int id,
        List<Translation<TvSeriesTranslationData>> translations
) implements TranslationsResponse<TvSeriesTranslationData>, TmdbModel {

    public TvSeriesTranslations {
        translations = TmdbCollections.list(translations);
    }
}
