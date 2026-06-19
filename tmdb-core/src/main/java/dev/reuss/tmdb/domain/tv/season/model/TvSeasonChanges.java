package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.change.Change;
import dev.reuss.tmdb.common.change.ChangesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Changes for a TMDB TV season.
 *
 * @param changes TV season changes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonChanges(
        List<Change> changes
) implements ChangesResponse, TmdbModel {

    public TvSeasonChanges {
        changes = TmdbCollections.list(changes);
    }
}
