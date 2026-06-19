package dev.reuss.tmdb.domain.search.model.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Collection returned by TMDB collection search.
 *
 * @param adult            whether the collection is marked as adult
 * @param backdropPath     backdrop image path
 * @param id               TMDB collection id
 * @param name             localized collection name
 * @param originalLanguage original language code
 * @param originalName     original collection name
 * @param overview         collection overview
 * @param posterPath       poster image path
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchCollection(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        int id,

        String name,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        @JsonProperty("poster_path")
        String posterPath
) implements TmdbModel {
}