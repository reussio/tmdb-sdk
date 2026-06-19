package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.video.VideosResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Videos for a TMDB movie.
 *
 * @param id      TMDB movie id
 * @param results movie videos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieVideos(
        int id,
        List<MovieVideo> results
) implements VideosResponse<MovieVideo>, TmdbModel {

    public MovieVideos {
        results = TmdbCollections.list(results);
    }
}
