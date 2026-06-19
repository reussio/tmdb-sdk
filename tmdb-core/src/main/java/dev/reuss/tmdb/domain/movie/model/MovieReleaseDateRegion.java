package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Release dates for a specific country.
 *
 * @param iso31661     ISO 3166-1 country code
 * @param releaseDates release dates
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieReleaseDateRegion(
        @JsonProperty("iso_3166_1")
        String iso31661,

        @JsonProperty("release_dates")
        List<MovieReleaseDate> releaseDates
) implements TmdbModel {

    public MovieReleaseDateRegion {
        releaseDates = TmdbCollections.list(releaseDates);
    }
}
