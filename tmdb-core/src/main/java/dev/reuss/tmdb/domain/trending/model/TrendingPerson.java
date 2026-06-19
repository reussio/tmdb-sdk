package dev.reuss.tmdb.domain.trending.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;
import dev.reuss.tmdb.value.media.MediaType;

import java.util.List;

/**
 * Person returned by TMDB people trending.
 *
 * @param adult              whether the person is marked as adult
 * @param id                 TMDB person id
 * @param name               person name
 * @param originalName       original person name
 * @param mediaType          media type, usually {@code person}
 * @param popularity         person popularity
 * @param gender             gender value returned by TMDB
 * @param knownForDepartment known department
 * @param profilePath        profile image path
 * @param knownFor           known movie or TV results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TrendingPerson(
        boolean adult,

        int id,

        String name,

        @JsonProperty("original_name")
        String originalName,

        @JsonProperty("media_type")
        MediaType mediaType,

        double popularity,

        int gender,

        @JsonProperty("known_for_department")
        String knownForDepartment,

        @JsonProperty("profile_path")
        String profilePath,

        @JsonProperty("known_for")
        List<TrendingPersonKnownFor> knownFor
) implements TmdbModel {
    public TrendingPerson {
        knownFor = TmdbCollections.list(knownFor);
    }

}
