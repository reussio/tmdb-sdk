package dev.reuss.tmdb.common.credit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Crew credit for a TMDB resource.
 *
 * @param adult              whether the person is marked as adult
 * @param gender             gender
 * @param id                 TMDB person id
 * @param knownForDepartment known for department
 * @param name               person name
 * @param originalName       original person name
 * @param popularity         popularity
 * @param profilePath        profile image path
 * @param creditId           credit id
 * @param department         department
 * @param job                job
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CrewCredit(
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

        @JsonProperty("credit_id")
        String creditId,

        String department,

        String job
) implements TmdbModel {
}
