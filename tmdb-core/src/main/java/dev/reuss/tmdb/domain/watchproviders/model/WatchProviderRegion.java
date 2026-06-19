package dev.reuss.tmdb.domain.watchproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Region with available TMDB watch provider data.
 *
 * @param iso31661    ISO 3166-1 region code
 * @param englishName English region name
 * @param nativeName  native region name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WatchProviderRegion(
        @JsonProperty("iso_3166_1")
        String iso31661,

        @JsonProperty("english_name")
        String englishName,

        @JsonProperty("native_name")
        String nativeName
) implements TmdbModel {
}
