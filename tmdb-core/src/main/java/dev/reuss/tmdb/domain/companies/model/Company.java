package dev.reuss.tmdb.domain.companies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * TMDB company details.
 *
 * @param description   company description
 * @param headquarters  company headquarters
 * @param homepage      company homepage URL
 * @param id            TMDB company id
 * @param logoPath      TMDB logo image path
 * @param name          company name
 * @param originCountry origin country code
 * @param parentCompany parent company information, if available
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Company(
        String description,

        String headquarters,

        String homepage,

        int id,

        @JsonProperty("logo_path")
        String logoPath,

        String name,

        @JsonProperty("origin_country")
        String originCountry,

        @JsonProperty("parent_company")
        Object parentCompany
) implements TmdbModel {
}