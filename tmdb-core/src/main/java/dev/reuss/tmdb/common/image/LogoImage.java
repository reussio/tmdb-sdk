package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Represents logo image metadata returned by TMDB.
 *
 * @param aspectRatio logo aspect ratio
 * @param filePath    TMDB image file path
 * @param height      logo height in pixels
 * @param id          TMDB image id
 * @param fileType    original logo file type, for example {@code .svg} or {@code .png}
 * @param voteAverage average image vote
 * @param voteCount   image vote count
 * @param width       logo width in pixels
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LogoImage(
        @JsonProperty("aspect_ratio")
        double aspectRatio,

        @JsonProperty("file_path")
        String filePath,

        int height,

        String id,

        @JsonProperty("file_type")
        String fileType,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        int width
) implements TmdbModel {
}
