package dev.reuss.tmdb.domain.tv.episode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Video for a TMDB TV episode.
 *
 * @param iso6391     ISO 639-1 language code
 * @param iso31661    ISO 3166-1 region code
 * @param name        video name
 * @param key         video key, for example the YouTube video id
 * @param site        video provider site
 * @param size        video size
 * @param type        video type
 * @param official    whether the video is official
 * @param publishedAt publish timestamp
 * @param id          TMDB video id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeVideo(
        @JsonProperty("iso_639_1")
        String iso6391,

        @JsonProperty("iso_3166_1")
        String iso31661,

        String name,

        String key,

        String site,

        int size,

        String type,

        boolean official,

        @JsonProperty("published_at")
        String publishedAt,

        String id
) implements TmdbModel {
}