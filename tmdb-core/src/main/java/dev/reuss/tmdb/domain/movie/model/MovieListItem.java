package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Movie item used in paged movie list responses.
 *
 * @param adult            whether the movie is marked as adult
 * @param backdropPath     backdrop image path
 * @param genreIds         genre ids
 * @param id               TMDB movie id
 * @param originalLanguage original language
 * @param originalTitle    original title
 * @param overview         movie overview
 * @param popularity       popularity
 * @param posterPath       poster image path
 * @param releaseDate      release date
 * @param title            movie title
 * @param video            whether the movie has video flag
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieListItem(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        int id,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_title")
        String originalTitle,

        String overview,

        double popularity,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("release_date")
        String releaseDate,

        String title,

        boolean video,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount
) implements TmdbModel {

    public MovieListItem {
        genreIds = TmdbCollections.list(genreIds);
    }
}