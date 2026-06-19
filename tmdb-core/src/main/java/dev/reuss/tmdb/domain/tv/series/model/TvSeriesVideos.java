package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.video.VideosResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Videos for a TMDB TV series.
 *
 * @param id      TMDB TV series id
 * @param results TV series videos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesVideos(
        int id,
        List<TvSeriesVideo> results
) implements VideosResponse<TvSeriesVideo>, TmdbModel {

    public TvSeriesVideos {
        results = TmdbCollections.list(results);
    }
}