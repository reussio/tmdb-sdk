package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Release date entry for a movie.
 *
 * @param certification certification
 * @param descriptors   certification descriptors
 * @param iso6391       ISO 639-1 language code
 * @param note          release note
 * @param releaseDate   release timestamp
 * @param type          release type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieReleaseDate(
        String certification,

        List<String> descriptors,

        @JsonProperty("iso_639_1")
        String iso6391,

        String note,

        @JsonProperty("release_date")
        String releaseDate,

        int type
) implements TmdbModel {

    public MovieReleaseDate {
        descriptors = TmdbCollections.list(descriptors);
    }

    public MovieReleaseType releaseType() {
        return MovieReleaseType.fromValue(type);
    }
}