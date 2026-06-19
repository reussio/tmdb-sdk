package dev.reuss.tmdb.domain.companies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.name.AlternativeNamesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Alternative names for a TMDB company.
 *
 * @param id      TMDB company id
 * @param results alternative company names
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CompanyAlternativeNames(
        int id,
        List<CompanyAlternativeName> results
) implements AlternativeNamesResponse<CompanyAlternativeName>, TmdbModel {

    public CompanyAlternativeNames {
        results = TmdbCollections.list(results);
    }
}