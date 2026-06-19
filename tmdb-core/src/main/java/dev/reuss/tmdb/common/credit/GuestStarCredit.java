package dev.reuss.tmdb.common.credit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Guest star credit for a TMDB TV episode.
 *
 * @param character          played character
 * @param creditId           credit id
 * @param order              credit order
 * @param adult              whether the person is marked as adult
 * @param gender             gender
 * @param id                 TMDB person id
 * @param knownForDepartment known for department
 * @param name               person name
 * @param originalName       original person name
 * @param popularity         popularity
 * @param profilePath        profile image path
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GuestStarCredit(
        String character,

        @JsonProperty("credit_id")
        String creditId,

        Integer order,

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
        String profilePath
) implements TmdbModel {
}
