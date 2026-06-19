package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Aggregate crew credit for a TMDB TV series.
 *
 * @param adult              whether the person is marked as adult
 * @param gender             TMDB gender value
 * @param id                 TMDB person id
 * @param knownForDepartment known department
 * @param name               person name
 * @param originalName       original person name
 * @param popularity         person popularity
 * @param profilePath        profile image path
 * @param jobs               aggregate crew jobs
 * @param department         crew department
 * @param totalEpisodeCount  total episode count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesAggregateCrewCredit(
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

        List<TvSeriesAggregateCrewJob> jobs,

        String department,

        @JsonProperty("total_episode_count")
        int totalEpisodeCount
) implements TmdbModel {

    public TvSeriesAggregateCrewCredit {
        jobs = TmdbCollections.list(jobs);
    }
}
