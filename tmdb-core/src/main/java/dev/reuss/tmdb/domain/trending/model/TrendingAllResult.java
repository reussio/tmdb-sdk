package dev.reuss.tmdb.domain.trending.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;
import dev.reuss.tmdb.value.media.MediaType;

import java.util.List;

/**
 * Result item returned by TMDB trending all.
 *
 * <p>This model supports movie, TV and person results. Fields that do not
 * apply to the concrete media type may be {@code null} or empty.</p>
 *
 * @param adult            whether the result is marked as adult
 * @param backdropPath     backdrop image path
 * @param id               TMDB resource id
 * @param title            movie title
 * @param originalTitle    original movie title
 * @param name             TV show or person name
 * @param originalName     original TV show or person name
 * @param originalLanguage original language code
 * @param overview         overview
 * @param posterPath       poster image path
 * @param profilePath      person profile image path
 * @param mediaType        media type, for example {@code movie}, {@code tv} or {@code person}
 * @param genreIds         genre ids
 * @param popularity       popularity
 * @param releaseDate      movie release date
 * @param firstAirDate     TV first air date
 * @param video            whether the movie has video content
 * @param voteAverage      vote average
 * @param voteCount        vote count
 * @param originCountry    TV origin countries
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TrendingAllResult(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        int id,

        String title,

        @JsonProperty("original_title")
        String originalTitle,

        String name,

        @JsonProperty("original_name")
        String originalName,

        @JsonProperty("original_language")
        String originalLanguage,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("profile_path")
        String profilePath,

        @JsonProperty("media_type")
        MediaType mediaType,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        double popularity,

        @JsonProperty("release_date")
        String releaseDate,

        @JsonProperty("first_air_date")
        String firstAirDate,

        boolean video,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("origin_country")
        List<String> originCountry
) implements TmdbModel {

    public TrendingAllResult {
        genreIds = TmdbCollections.list(genreIds);
        originCountry = TmdbCollections.list(originCountry);
    }
}
