package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Spoken language of a movie.
 *
 * @param englishName English language name
 * @param iso6391     ISO 639-1 language code
 * @param name        native language name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieSpokenLanguage(
        @JsonProperty("english_name")
        String englishName,

        @JsonProperty("iso_639_1")
        String iso6391,

        String name
) implements TmdbModel {
}