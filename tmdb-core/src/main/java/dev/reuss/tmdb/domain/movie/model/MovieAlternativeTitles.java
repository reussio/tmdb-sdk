package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.title.AlternativeTitle;
import dev.reuss.tmdb.common.title.AlternativeTitlesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Alternative titles for a TMDB movie.
 *
 * @param id     TMDB movie id
 * @param titles alternative titles
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieAlternativeTitles(
        int id,
        List<AlternativeTitle> titles
) implements AlternativeTitlesResponse, TmdbModel {

    public MovieAlternativeTitles {
        titles = TmdbCollections.list(titles);
    }

    @Override
    public List<AlternativeTitle> alternativeTitles() {
        return titles;
    }
}
