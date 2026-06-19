package dev.reuss.tmdb.domain.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Alternative name for a TMDB network.
 *
 * @param name alternative network name
 * @param type optional name type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NetworkAlternativeName(
        String name,
        String type
) implements TmdbModel {
}