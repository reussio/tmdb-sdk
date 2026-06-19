package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Movie production country.
 *
 * @param iso31661 ISO 3166-1 country code
 * @param name     country name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieProductionCountry(
        @JsonProperty("iso_3166_1")
        String iso31661,

        String name
) implements TmdbModel {
}