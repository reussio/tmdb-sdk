package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.title.AlternativeTitle;
import dev.reuss.tmdb.common.title.AlternativeTitlesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Alternative titles for a TMDB TV series.
 *
 * @param id      TMDB TV series id
 * @param results alternative titles
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesAlternativeTitles(
        int id,
        List<AlternativeTitle> results
) implements AlternativeTitlesResponse, TmdbModel {

    public TvSeriesAlternativeTitles {
        results = TmdbCollections.list(results);
    }

    @Override
    public List<AlternativeTitle> alternativeTitles() {
        return results;
    }
}
