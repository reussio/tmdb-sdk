package dev.reuss.tmdb.domain.configuration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Language metadata used throughout TMDB.
 *
 * @param iso6391     ISO 639-1 language code
 * @param englishName English language name
 * @param name        native language name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConfigurationLanguage(
        @JsonProperty("iso_639_1")
        String iso6391,

        @JsonProperty("english_name")
        String englishName,

        String name
) implements TmdbModel {
}
