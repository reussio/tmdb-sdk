package dev.reuss.tmdb.domain.trending.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;
import dev.reuss.tmdb.value.media.MediaType;

import java.util.List;

/**
 * TV show returned by TMDB TV trending.
 *
 * @param adult            whether the TV show is marked as adult
 * @param backdropPath     backdrop image path
 * @param id               TMDB TV show id
 * @param name             localized TV show name
 * @param originalLanguage original language code
 * @param originalName     original TV show name
 * @param overview         TV show overview
 * @param posterPath       poster image path
 * @param mediaType        media type, usually {@code tv}
 * @param genreIds         genre ids
 * @param popularity       TV show popularity
 * @param firstAirDate     first air date
 * @param voteAverage      vote average
 * @param voteCount        vote count
 * @param originCountry    origin countries
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TrendingTvShow(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        int id,

        String name,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("media_type")
        MediaType mediaType,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        double popularity,

        @JsonProperty("first_air_date")
        String firstAirDate,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("origin_country")
        List<String> originCountry
) implements TmdbModel {
    public TrendingTvShow {
        genreIds = TmdbCollections.list(genreIds);
        originCountry = TmdbCollections.list(originCountry);
    }

}
