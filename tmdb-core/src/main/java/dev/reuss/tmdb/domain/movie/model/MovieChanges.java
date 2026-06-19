package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.change.Change;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Changes for a TMDB movie.
 *
 * @param changes movie changes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieChanges(
        List<Change> changes
) implements TmdbModel {

    public MovieChanges {
        changes = TmdbCollections.list(changes);
    }
}
