package dev.reuss.tmdb.domain.credits.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.value.media.MediaType;

/**
 * Person information included in a TMDB credit response.
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
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CreditPerson(
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
        String profilePath
) implements TmdbModel {
}