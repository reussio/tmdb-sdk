package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Represents image metadata returned by TMDB.
 *
 * @param aspectRatio image aspect ratio
 * @param height      image height in pixels
 * @param iso6391     optional ISO 639-1 language code
 * @param filePath    TMDB image file path
 * @param voteAverage average image vote
 * @param voteCount   image vote count
 * @param width       image width in pixels
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbImage(
        @JsonProperty("aspect_ratio")
        double aspectRatio,

        int height,

        @JsonProperty("iso_639_1")
        String iso6391,

        @JsonProperty("file_path")
        String filePath,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        int width
) implements TmdbModel {
}
