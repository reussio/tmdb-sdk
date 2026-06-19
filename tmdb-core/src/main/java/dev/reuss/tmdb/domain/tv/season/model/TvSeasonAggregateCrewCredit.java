package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Aggregate crew credit for a TV season.
 *
 * @param adult              whether the person is marked as adult
 * @param gender             gender
 * @param id                 TMDB person id
 * @param knownForDepartment known for department
 * @param name               person name
 * @param originalName       original person name
 * @param popularity         popularity
 * @param profilePath        profile image path
 * @param jobs               jobs in this season
 * @param department         department
 * @param totalEpisodeCount  total episode count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonAggregateCrewCredit(
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

        List<TvSeasonAggregateCrewJob> jobs,

        String department,

        @JsonProperty("total_episode_count")
        int totalEpisodeCount
) implements TmdbModel {

    public TvSeasonAggregateCrewCredit {
        jobs = TmdbCollections.list(jobs);
    }
}
