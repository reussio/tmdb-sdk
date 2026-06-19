package dev.reuss.tmdb.domain.search.model.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Company returned by TMDB company search.
 *
 * @param id            TMDB company id
 * @param logoPath      company logo image path
 * @param name          company name
 * @param originCountry origin country code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchCompany(
        int id,

        @JsonProperty("logo_path")
        String logoPath,

        String name,

        @JsonProperty("origin_country")
        String originCountry
) implements TmdbModel {
}