package dev.reuss.tmdb.domain.configuration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Timezones used by a TMDB country.
 *
 * @param iso31661 TMDB country code
 * @param zones    timezone identifiers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Timezone(
        @JsonProperty("iso_3166_1")
        String iso31661,

        List<String> zones
) implements TmdbModel {

    public Timezone {
        zones = TmdbCollections.list(zones);
    }
}
