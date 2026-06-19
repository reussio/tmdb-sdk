package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Media item a popular person is known for.
 *
 * @param adult            whether the media item is marked as adult
 * @param backdropPath     backdrop image path
 * @param genreIds         genre ids
 * @param id               TMDB media id
 * @param mediaType        media type, for example movie or tv
 * @param originalLanguage original language
 * @param originalTitle    original movie title
 * @param originalName     original TV name
 * @param overview         overview
 * @param posterPath       poster image path
 * @param releaseDate      movie release date
 * @param firstAirDate     TV first air date
 * @param title            movie title
 * @param name             TV name
 * @param video            whether this movie has video flag
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PopularPersonKnownFor(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        int id,

        @JsonProperty("media_type")
        String mediaType,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_title")
        String originalTitle,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("release_date")
        String releaseDate,

        @JsonProperty("first_air_date")
        String firstAirDate,

        String title,

        String name,

        boolean video,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount
) implements TmdbModel {

    public PopularPersonKnownFor {
        genreIds = TmdbCollections.list(genreIds);
    }
}