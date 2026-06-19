package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Date range for now playing movies.
 *
 * @param maximum maximum release date
 * @param minimum minimum release date
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieNowPlayingDates(
        String maximum,
        String minimum
) {
}
