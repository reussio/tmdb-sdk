package dev.reuss.tmdb.domain.collection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Movie that is part of a TMDB collection.
 *
 * @param adult            whether the movie is adult content
 * @param backdropPath     backdrop path
 * @param id               movie id
 * @param name             movie name
 * @param originalName     original movie name
 * @param overview         movie overview
 * @param posterPath       poster path
 * @param mediaType        media type
 * @param originalLanguage original language
 * @param genreIds         genre ids
 * @param popularity       popularity score
 * @param releaseDate      release date
 * @param video            whether this is a video
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CollectionPart(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        int id,
        String name,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("media_type")
        String mediaType,

        @JsonProperty("original_language")
        String originalLanguage,

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
) {

    public CollectionPart {
        genreIds = TmdbCollections.list(genreIds);
    }
}
