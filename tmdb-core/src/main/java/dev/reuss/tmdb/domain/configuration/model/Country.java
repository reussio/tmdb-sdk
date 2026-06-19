package dev.reuss.tmdb.domain.configuration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Country metadata used throughout TMDB.
 *
 * @param iso31661    TMDB country code
 * @param englishName English country name
 * @param nativeName  native country name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Country(
        @JsonProperty("iso_3166_1")
        String iso31661,

        @JsonProperty("english_name")
        String englishName,

        @JsonProperty("native_name")
        String nativeName
) implements TmdbModel {
}
