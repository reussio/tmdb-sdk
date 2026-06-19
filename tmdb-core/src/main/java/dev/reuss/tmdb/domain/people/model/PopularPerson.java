package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Popular TMDB person.
 *
 * @param adult              whether the person is marked as adult
 * @param gender             gender
 * @param id                 TMDB person id
 * @param knownFor           known media
 * @param knownForDepartment known for department
 * @param name               person name
 * @param popularity         popularity
 * @param profilePath        profile image path
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PopularPerson(
        boolean adult,

        int gender,

        int id,

        @JsonProperty("known_for")
        List<PopularPersonKnownFor> knownFor,

        @JsonProperty("known_for_department")
        String knownForDepartment,

        String name,

        double popularity,

        @JsonProperty("profile_path")
        String profilePath
) implements TmdbModel {

    public PopularPerson {
        knownFor = TmdbCollections.list(knownFor);
    }
}