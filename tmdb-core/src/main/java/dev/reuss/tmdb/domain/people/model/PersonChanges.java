package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.change.Change;
import dev.reuss.tmdb.common.change.ChangesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Recent TMDB changes for a person.
 *
 * @param changes changed person fields
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonChanges(
        List<Change> changes
) implements ChangesResponse, TmdbModel {

    public PersonChanges {
        changes = TmdbCollections.list(changes);
    }
}
