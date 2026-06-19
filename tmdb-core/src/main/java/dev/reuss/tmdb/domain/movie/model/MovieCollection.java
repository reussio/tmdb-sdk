package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Collection a movie belongs to.
 *
 * @param id           TMDB collection id
 * @param name         collection name
 * @param posterPath   poster image path
 * @param backdropPath backdrop image path
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieCollection(
        int id,

        String name,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("backdrop_path")
        String backdropPath
) implements TmdbModel {
}