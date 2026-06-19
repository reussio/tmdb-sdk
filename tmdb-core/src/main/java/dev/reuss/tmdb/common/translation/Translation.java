package dev.reuss.tmdb.common.translation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Translation metadata and endpoint-specific translated data.
 *
 * @param iso31661    ISO 3166-1 region code
 * @param iso6391     ISO 639-1 language code
 * @param name        localized language name
 * @param englishName English language name
 * @param data        endpoint-specific translated data
 * @param <T>         translated data type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Translation<T>(
        @JsonProperty("iso_3166_1")
        String iso31661,

        @JsonProperty("iso_639_1")
        String iso6391,

        String name,

        @JsonProperty("english_name")
        String englishName,

        T data
) implements TmdbModel {
}
