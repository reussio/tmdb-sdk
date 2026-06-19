package dev.reuss.tmdb.domain.search.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

import java.util.List;

/**
 * Person returned by TMDB person search.
 *
 * @param adult              whether the person is marked as adult
 * @param gender             gender value returned by TMDB
 * @param id                 TMDB person id
 * @param knownForDepartment known department
 * @param name               person name
 * @param originalName       original person name
 * @param popularity         person popularity
 * @param profilePath        profile image path
 * @param knownFor           known movie or TV results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchPerson(
        boolean adult,

        int gender,

        int id,

        @JsonProperty("known_for_department")
        String knownForDepartment,

        String name,

        @JsonProperty("original_name")
        String originalName,

        double popularity,

        @JsonProperty("profile_path")
        String profilePath,

        @JsonProperty("known_for")
        List<SearchPersonKnownFor> knownFor
) implements TmdbModel {
}