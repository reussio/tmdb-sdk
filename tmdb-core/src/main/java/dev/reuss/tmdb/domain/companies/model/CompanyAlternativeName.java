package dev.reuss.tmdb.domain.companies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Alternative name for a TMDB company.
 *
 * @param name alternative company name
 * @param type optional name type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CompanyAlternativeName(
        String name,
        String type
) implements TmdbModel {
}