package dev.reuss.tmdb.domain.watchproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.Map;

/**
 * TMDB watch provider.
 *
 * @param displayPriorities region-specific display priorities
 * @param displayPriority   default display priority
 * @param logoPath          provider logo image path
 * @param providerName      provider name
 * @param providerId        TMDB provider id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WatchProvider(
        @JsonProperty("display_priorities")
        Map<String, Integer> displayPriorities,

        @JsonProperty("display_priority")
        int displayPriority,

        @JsonProperty("logo_path")
        String logoPath,

        @JsonProperty("provider_name")
        String providerName,

        @JsonProperty("provider_id")
        int providerId
) implements TmdbModel {
    public WatchProvider {
        displayPriorities = TmdbCollections.map(displayPriorities);
    }

}