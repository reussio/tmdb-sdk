package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.keyword.Keyword;
import dev.reuss.tmdb.common.keyword.KeywordsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Keywords for a TMDB TV series.
 *
 * @param id      TMDB TV series id
 * @param results TV series keywords
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesKeywords(
        int id,
        List<Keyword> results
) implements KeywordsResponse, TmdbModel {

    public TvSeriesKeywords {
        results = TmdbCollections.list(results);
    }

    @Override
    public List<Keyword> keywords() {
        return results;
    }
}
