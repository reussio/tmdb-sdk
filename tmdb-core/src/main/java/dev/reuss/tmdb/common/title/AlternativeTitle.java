package dev.reuss.tmdb.common.title;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Alternative title for a TMDB resource.
 *
 * @param iso31661 ISO 3166-1 country or region code
 * @param title    alternative title
 * @param type     alternative title type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AlternativeTitle(
        @JsonProperty("iso_3166_1")
        String iso31661,

        String title,

        String type
) implements TmdbModel {
}
