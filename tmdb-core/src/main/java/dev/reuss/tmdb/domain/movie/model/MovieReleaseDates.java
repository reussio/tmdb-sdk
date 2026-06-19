package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Release dates for a TMDB movie.
 *
 * @param id      TMDB movie id
 * @param results release dates grouped by country
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieReleaseDates(
        int id,
        List<MovieReleaseDateRegion> results
) implements TmdbModel {

    public MovieReleaseDates {
        results = TmdbCollections.list(results);
    }
}
