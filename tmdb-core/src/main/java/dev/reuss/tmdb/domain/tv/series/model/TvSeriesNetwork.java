package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * TV network used in TV series details.
 *
 * @param id TMDB network id
 * @param logoPath logo image path
 * @param name network name
 * @param originCountry origin country code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesNetwork(
        int id,

        @JsonProperty("logo_path")
        String logoPath,

        String name,

        @JsonProperty("origin_country")
        String originCountry
) implements TmdbModel {
}
