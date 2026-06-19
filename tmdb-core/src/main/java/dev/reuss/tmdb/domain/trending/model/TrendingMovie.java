package dev.reuss.tmdb.domain.trending.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;
import dev.reuss.tmdb.value.media.MediaType;

import java.util.List;

/**
 * Movie returned by TMDB movie trending.
 *
 * @param adult            whether the movie is marked as adult
 * @param backdropPath     backdrop image path
 * @param id               TMDB movie id
 * @param title            localized movie title
 * @param originalLanguage original language code
 * @param originalTitle    original movie title
 * @param overview         movie overview
 * @param posterPath       poster image path
 * @param mediaType        media type, usually {@code movie}
 * @param genreIds         genre ids
 * @param popularity       movie popularity
 * @param releaseDate      movie release date
 * @param video            whether the movie has video content
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TrendingMovie(
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

    public TrendingMovie {
        genreIds = TmdbCollections.list(genreIds);
    }
}
