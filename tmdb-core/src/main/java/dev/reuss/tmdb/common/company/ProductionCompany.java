package dev.reuss.tmdb.common.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Production company for a TMDB resource.
 *
 * @param id            TMDB company id
 * @param logoPath      company logo path
 * @param name          company name
 * @param originCountry origin country
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductionCompany(
        int id,

        @JsonProperty("logo_path")
        String logoPath,

        String name,

        @JsonProperty("origin_country")
        String originCountry
) implements TmdbModel {
}
