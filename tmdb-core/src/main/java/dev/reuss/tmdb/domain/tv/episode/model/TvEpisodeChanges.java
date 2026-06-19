package dev.reuss.tmdb.domain.tv.episode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.change.Change;
import dev.reuss.tmdb.common.change.ChangesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Changes for a TMDB TV episode.
 *
 * @param changes TV episode changes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeChanges(
        List<Change> changes
) implements ChangesResponse, TmdbModel {

    public TvEpisodeChanges {
        changes = TmdbCollections.list(changes);
    }
}
