package dev.reuss.tmdb.domain.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.name.AlternativeNamesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Alternative names for a TMDB network.
 *
 * @param id      TMDB network id
 * @param results alternative network names
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NetworkAlternativeNames(
        int id,
        List<NetworkAlternativeName> results
) implements AlternativeNamesResponse<NetworkAlternativeName>, TmdbModel {

    public NetworkAlternativeNames {
        results = TmdbCollections.list(results);
    }

}