package dev.reuss.tmdb.domain.configuration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * TMDB jobs grouped by department.
 *
 * @param department department name
 * @param jobs       jobs in the department
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record JobDepartment(
        String department,
        List<String> jobs
) implements TmdbModel {

    public JobDepartment {
        jobs = TmdbCollections.list(jobs);
    }
}
