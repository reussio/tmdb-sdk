package dev.reuss.tmdb.domain.collection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Details for a TMDB collection.
 *
 * @param id               collection id
 * @param name             collection name
 * @param originalLanguage original language
 * @param originalName     original collection name
 * @param overview         collection overview
 * @param posterPath       poster path
 * @param backdropPath     backdrop path
 * @param parts            movies that are part of the collection
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CollectionDetails(
        int id,
        String name,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("backdrop_path")
        String backdropPath,

        List<CollectionPart> parts
) {

    public CollectionDetails {
        parts = TmdbCollections.list(parts);
    }
}
