package dev.reuss.tmdb.domain.find.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;
import dev.reuss.tmdb.value.media.MediaType;

import java.util.List;

/**
 * Movie result returned by TMDB find.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FindMovieResult(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        int id,

        String title,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_title")
        String originalTitle,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("media_type")
        MediaType mediaType,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        double popularity,

        @JsonProperty("release_date")
        String releaseDate,

        boolean video,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount
) implements TmdbModel {

    public FindMovieResult {
        genreIds = TmdbCollections.list(genreIds);
    }
}