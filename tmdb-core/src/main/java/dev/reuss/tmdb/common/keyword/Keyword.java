package dev.reuss.tmdb.common.keyword;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * TMDB keyword.
 *
 * @param id   TMDB keyword id
 * @param name keyword name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Keyword(
        int id,
        String name
) implements TmdbModel {
}
