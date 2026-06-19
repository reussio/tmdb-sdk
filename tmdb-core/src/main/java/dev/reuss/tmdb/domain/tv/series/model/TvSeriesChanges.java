package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.change.Change;
import dev.reuss.tmdb.common.change.ChangesResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Recent changes for a TMDB TV series.
 *
 * @param changes changed TV series fields
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesChanges(
        List<Change> changes
) implements ChangesResponse, TmdbModel {

    public TvSeriesChanges {
        changes = TmdbCollections.list(changes);
    }
}
