package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Content rating for a TMDB TV series.
 *
 * @param descriptors rating descriptors
 * @param iso31661    ISO 3166-1 region code
 * @param rating      content rating
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesContentRating(
        List<String> descriptors,

        @JsonProperty("iso_3166_1")
        String iso31661,

        String rating
) implements TmdbModel {

    public TvSeriesContentRating {
        descriptors = TmdbCollections.list(descriptors);
    }
}
