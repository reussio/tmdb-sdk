package dev.reuss.tmdb.domain.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * TMDB network details.
 *
 * @param headquarters  network headquarters
 * @param homepage      network homepage URL
 * @param id            TMDB network id
 * @param logoPath      TMDB logo image path
 * @param name          network name
 * @param originCountry origin country code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Network(
        String headquarters,

        String homepage,

        int id,

        @JsonProperty("logo_path")
        String logoPath,

        String name,

        @JsonProperty("origin_country")
        String originCountry
) implements TmdbModel {
}
