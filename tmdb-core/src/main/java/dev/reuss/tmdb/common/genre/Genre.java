package dev.reuss.tmdb.common.genre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * TMDB genre.
 *
 * @param id   TMDB genre id
 * @param name localized genre name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Genre(
        int id,
        String name
) implements TmdbModel {
}
