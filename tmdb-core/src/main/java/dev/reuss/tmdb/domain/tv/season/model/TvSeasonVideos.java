package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.video.VideosResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Videos for a TMDB TV season.
 *
 * @param id      TMDB season id
 * @param results TV season videos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonVideos(
        int id,
        List<TvSeasonVideo> results
) implements VideosResponse<TvSeasonVideo>, TmdbModel {

    public TvSeasonVideos {
        results = TmdbCollections.list(results);
    }
}
