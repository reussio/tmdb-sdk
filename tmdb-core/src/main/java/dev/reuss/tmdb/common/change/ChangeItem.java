package dev.reuss.tmdb.common.change;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Single change item for a TMDB resource field.
 *
 * @param id            change item id
 * @param action        change action
 * @param time          change timestamp
 * @param iso6391       ISO 639-1 language code
 * @param iso31661      ISO 3166-1 region code
 * @param value         changed value
 * @param originalValue previous value, if provided by the endpoint
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ChangeItem(
        String id,

        String action,

        String time,

        @JsonProperty("iso_639_1")
        String iso6391,

        @JsonProperty("iso_3166_1")
        String iso31661,

        Object value,

        @JsonProperty("original_value")
        Object originalValue
) implements TmdbModel {
}
