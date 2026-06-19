package dev.reuss.tmdb.domain.search.model.tv;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

import java.util.List;

/**
 * TV show returned by TMDB TV search.
 *
 * @param adult            whether the TV show is marked as adult
 * @param backdropPath     backdrop image path
 * @param genreIds         genre ids
 * @param id               TMDB TV show id
 * @param originCountry    origin countries
 * @param originalLanguage original language code
 * @param originalName     original TV show name
 * @param overview         TV show overview
 * @param popularity       TV show popularity
 * @param posterPath       poster image path
 * @param firstAirDate     first air date
 * @param name             localized TV show name
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchTvShow(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        int id,

        @JsonProperty("origin_country")
        List<String> originCountry,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        double popularity,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("first_air_date")
        String firstAirDate,

        String name,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount
) implements TmdbModel {
}