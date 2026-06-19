package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Creator of a TMDB TV series.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesCreator(
        int id,

        @JsonProperty("credit_id")
        String creditId,

        String name,

        int gender,

        @JsonProperty("profile_path")
        String profilePath
) implements TmdbModel {
}
