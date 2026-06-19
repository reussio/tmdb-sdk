package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.keyword.Keyword;
import dev.reuss.tmdb.common.keyword.KeywordsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Keywords for a TMDB movie.
 *
 * @param id       TMDB movie id
 * @param keywords movie keywords
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieKeywords(
        int id,
        List<Keyword> keywords
) implements KeywordsResponse, TmdbModel {

    public MovieKeywords {
        keywords = TmdbCollections.list(keywords);
    }
}
