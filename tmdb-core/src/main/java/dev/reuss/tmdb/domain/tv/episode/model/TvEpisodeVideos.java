package dev.reuss.tmdb.domain.tv.episode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.video.VideosResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Videos for a TMDB TV episode.
 *
 * @param id      TMDB episode id
 * @param results TV episode videos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeVideos(
        int id,
        List<TvEpisodeVideo> results
) implements VideosResponse<TvEpisodeVideo>, TmdbModel {

    public TvEpisodeVideos {
        results = TmdbCollections.list(results);
    }
}
